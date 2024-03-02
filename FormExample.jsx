import React, { useState } from "react";

const FormExample = () => {
  const [userName, setUserName] = useState("");

  const [newUserDetails, setNewUserDetails] = useState();

  const getUserName = (event) => {
    setUserName(event.target.value);
  };

  const userDetails = (e) => {
    e.preventDefault();
    setNewUserDetails(userName);
  };

  return (
    <section className="formSection">
      <h2>Hello,{newUserDetails}</h2>

      <div className="inputDiv">
        <form onSubmit={userDetails}>
          <input
            type="text"
            placeholder="Enter your Name"
            onChange={getUserName}
          />
          <br />
          <button className="submitBtn" type="submit">
            Submit
          </button>
        </form>
      </div>
    </section>
  );
};

export default FormExample;
