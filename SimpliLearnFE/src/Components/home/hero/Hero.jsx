import React from "react";
import Heading from "../../common/heading/Heading";
import "./Hero.css";
import { Redirect } from "react-router-dom/cjs/react-router-dom";

const Hero = () => {

  const navigate = Redirect;

  const handleClick = () => {
    navigate("/register");
  }

  return (
    <>
      <section className='hero'>
        <div className='container'>
          <div className='row'>
            <Heading subtitle='WELCOME TO ACADEMIA' title='Best Online Education Expertise' />
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
            <div className='button'>
              <button className='primary-btn' onClick={handleClick}>
                GET STARTED NOW <i className='fa fa-long-arrow-alt-right'></i>
              </button>
              <button>
                VIEW COURSE <i className='fa fa-long-arrow-alt-right'></i>
              </button>
            </div>
          </div>
        </div>
      </section>
      <div className='margin'></div>
    </>
  )
}

export default Hero
