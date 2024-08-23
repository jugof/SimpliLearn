import React, { useState } from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBCardImage,
  MDBRow,
  MDBCol,
  MDBIcon,
  MDBInput
} from 'mdb-react-ui-kit';

function Login() {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleLogin = async (event) => {
    event.preventDefault();

    const loginData = {
      username,
      password
    };

    try {
      const response = await fetch('http://localhost:8080/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(loginData)
      });

      if (response.ok) {
        const token = await response.text(); // Receiving the token as a plain string

        console.log(" The generated JWT is: "  +token);

        // Store the JWT token in localStorage
        localStorage.setItem('jwtToken', token);

         // Redirect to the home page
         window.location.href = '/courses';

        // You can also manage any additional session data here, e.g., user info
      } else {
        console.error('Login failed');
      }
    } catch (error) {
      console.error('Error during login:', error);
    }
  };

  return (
    <div >
       <MDBContainer className="my-5 w-100">
        <MDBCard >
          <MDBRow className='g-0'>
            <div className='w-100 d-flex flex-row text-red justify-content-center align-items-center'>
              <MDBCol md='6' className='w-50'>
                <MDBCardImage
                  src='https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/img1.webp'
                  alt="login form"
                  className='rounded-start w-100'
                />
              </MDBCol>

              <MDBCol md='6' className='w-50'>
                <MDBCardBody className='d-flex flex-column'>
                  <div className='d-flex flex-row mt-2'>
                    <MDBIcon fas icon="cubes fa-3x me-3" style={{ color: '#ff6219' }}/>
                    <span className="h1 fw-bold mb-0 text-red">Login</span>
                  </div>

                  <h5 className="fw-normal my-4 pb-3" style={{ letterSpacing: '1px' }}>Sign into your account</h5>

                  <form onSubmit={handleLogin}>
                    <MDBInput
                      wrapperClass='mb-4'
                      label='Username'
                      id='username'
                      type='text'
                      placeholder='Enter your username'
                      size="lg"
                      value={username}
                      onChange={(e) => setUsername(e.target.value)}
                    />
                    <MDBInput
                      wrapperClass='mb-4'
                      label='Password'
                      id='password'
                      type='password'
                      placeholder='Enter your password'
                      size="lg"
                      value={password}
                      onChange={(e) => setPassword(e.target.value)}
                    />

                    <MDBBtn className="mb-4 px-5" color='dark' size='lg' type="submit">Login</MDBBtn>
                  </form>

                  <a className="small text-muted" href="/">Forgot password?</a>
                  <p className="mb-5 pb-lg-2" style={{ color: '#393f81' }}>Don't have an account? <a href="/registration" style={{ color: '#393f81' }}>Register here</a></p>

                  <div className='d-flex flex-row justify-content-start'>
                    <a href="#!" className="small text-muted me-1">Terms of use.</a>
                    <a href="#!" className="small text-muted">Privacy policy</a>
                  </div>
                </MDBCardBody>
              </MDBCol>
            </div>
          </MDBRow>
        </MDBCard>
      </MDBContainer>
    </div>
    
  );
}

export default Login;
