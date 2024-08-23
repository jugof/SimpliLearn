import React from "react";
import Heading from "../../common/heading/Heading";
import "./Hero.css";

const Hero = () => {

  const handleClick = (event) => {
    event.preventDefault(); // Prevents the default action
    window.location.href = '/courses';
  }

  const getStarted = (event) => {
    event.preventDefault(); // Prevents the default action
    window.location.href = '/registration';
  }

  return (
    <>
      <section className='hero'>
        <div className='container'>
          <div className='row'>
            <Heading subtitle='Welcome to Simpli-Learn' title='Best Online Education Expertise' />
            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
            <div className='button'>
              <button type="button hover:bg-red" className='primary-btn' onClick={getStarted} >
                GET STARTED NOW <i className='fa fa-long-arrow-alt-right'></i>
              </button>
              <button onClick={handleClick}>
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
