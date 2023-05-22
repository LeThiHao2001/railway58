import React, { useEffect, useState } from "react";
import CartDataService from "../services/cart.service";
import { Navigate, useNavigate, useParams } from "react-router-dom";

const Cart = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const [currentCart, setCurrentCart] = useState({
    id: id,
    title: "",
    description: "",
    isPaid: false,
    amount: ""
  });
  const [message, setMessage] = useState("");


  useEffect(() => {
    CartDataService.get(id)
      .then((response) => {
        const Carts = response.data;
        setCurrentCart(Carts);
      })
      .catch((e) => {
        console.log(e);
      });
  }, [])

  function onChangeTitle(e) {
    const title = e.target.value;
    let cart = {
      ...currentCart,
      title: title
    }
    setCurrentCart(cart);
  }

  function onChangeDescription(e) {
    const description = e.target.value;
    let cart = {
      ...currentCart,
      description: description
    }
    setCurrentCart(cart);
  }

  function onChangeAmount(e) {
    const amount = e.target.value;
    let cart = {
      ...currentCart,
      amount: amount
    }
    setCurrentCart(cart);
  }

  function updateisPaid(status) {
    var data = {
      id: currentCart.id,
      title: currentCart.title,
      description: currentCart.description,
      isPaid: status,
      amount: currentCart.amount
    };

    CartDataService.update(id, data)
      .then(response => {
        currentCart = {
          ...currentCart,
          isPaid: status
        }
        setCurrentCart(currentCart);
        console.log(response.data);
      })
      .catch(e => {
        console.log(e);
      });
  }

  function updateCart() {
    CartDataService.update(
      currentCart.id,
      currentCart
    )
      .then(response => {
        console.log(response.data);
        setMessage("The Cart was updated successfully!");
      })
      .catch(e => {
        console.log(e);
      });
  }

  function deleteCart() {
    CartDataService.deleteProduct(id)
      .then(response => {
        console.log(response.data);
        navigate('/products');
      })
      .catch(e => {
        console.log(e);
      });
  }


  return (
    <div>
      {currentCart ? (
        <div className="edit-form">
          <h4>Cart</h4>
          <form>
            <div className="form-group">
              <label htmlFor="title">Title</label>
              <input
                type="text"
                className="form-control"
                id="title"
                value={currentCart.title}
                onChange={onChangeTitle}
              />
            </div>
            <div className="form-group">
              <label htmlFor="description">Description</label>
              <input
                type="text"
                className="form-control"
                id="description"
                value={currentCart.description}
                onChange={onChangeDescription}
              />
            </div>

            <div className="form-group">
              <label>
                <strong>Status:</strong>
              </label>
              {currentCart.isPaid ? "isPaid" : "Pending"}
            </div>
            <div className="form-group">
              <label htmlFor="amount">Amount</label>
              <input
                type="text"
                className="form-control"
                id="amount"
                value={currentCart.amount}
                onChange={onChangeAmount}
              />
            </div>


          </form>

          {currentCart.isPaid ? (
            <button
              className="badge badge-primary mr-2"
              onClick={() => updateisPaid(false)}
            >
              UnPay
            </button>
          ) : (
            <button
              className="badge badge-primary mr-2"
              onClick={() => updateisPaid(true)}
            >
              Pay
            </button>
          )}

          <button
            className="badge badge-danger mr-2"
            onClick={deleteCart}
          >
            Delete
          </button>

          <button
            type="submit"
            className="badge badge-success"
            onClick={updateCart}
          >
            Update
          </button>
          <p>{message}</p>
        </div>
      ) : (
        <div>
          <br />
          <p>Please click on a Cart...</p>
        </div>
      )}
    </div>
  );
}

export default Cart;
