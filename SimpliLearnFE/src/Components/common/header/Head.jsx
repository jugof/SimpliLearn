import React from 'react'
import { Link } from 'react-router-dom/cjs/react-router-dom'

const Head = () => {

  return (
    <>
      <section className='head'>
        <div className="container flexSB">
            <div className="logo">
              <Link to= "/">
                <h1>SIMPLILEARN</h1> 
                <span>ONLINE EDUCATION & LEARNING</span>
              </Link>
            </div>
            <div className="social">
                <i className='fas fa-envelope icon'></i>
                <i className='fab fa-github icon'></i>
                <i className='fab fa-twitter icon'></i>
                <i className='fab fa-linkedin icon'></i>
            </div>
        </div>
      </section>
    </>
  )
}

export default Head
