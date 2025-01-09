import React, { useEffect, useState } from "react";
import axios from "axios";
import './Homepage.css'; // Import your CSS file

const Homepage = () => {
  const [products, setProducts] = useState([]);
  const [isError, setIsError] = useState(false);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/products");
        setProducts(response.data);
        setLoading(false);
      } catch (error) {
        setIsError(true);
        setLoading(false);
        console.error("Error fetching data:", error);
      }
    };

    fetchData();
  }, []);

  if (loading) {
    return <h2>Loading...</h2>;
  }

  if (isError) {
    return (
      <h2 className="text-center" style={{ padding: "10rem" }}>
        Something went wrong...
      </h2>
    );
  }

  return (
    <div className="grid">
      {products.map((product) => (
        <div className="card mb-3" key={product.id}>
          <div className="card-body">
            <h5 className="card-title">{product.name.toUpperCase()}</h5>
            <i className="card-brand">by {product.brand}</i>
            <hr className="hr-line" />
            <div className="home-cart-price">
              <h5 className="card-text">
                <i className="bi bi-currency-rupee"></i>
                {product.price}
              </h5>
            </div>
            <button className="btn-hover color-9">Add To Cart</button>
          </div>
        </div>
      ))}
    </div>
  );
};

export default Homepage;
