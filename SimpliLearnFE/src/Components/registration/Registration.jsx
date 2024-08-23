import React, { useState } from 'react';
import axios from 'axios';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBRow,
  MDBCol,
  MDBInput,
}
from 'mdb-react-ui-kit';

function Registration() {
  const [formData, setFormData] = useState({
    username: '',
    password: '',
    fullName: '',
    email: '',
    accountType: ''
  });


  const handleChange = (e) => {
    const { id, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [id]: value
    }));
  };

  const handleSubmit = async () => {
    try {
      const response = await axios.post('http://localhost:8080/register', formData);
      console.log('Form submitted successfully:', response.data);
      // Add any further actions here, like redirecting or showing a success message
    } catch (error) {
      console.error('Error submitting form:', error);
    }
  };

  const handleReset = () => {
    setFormData({
      username: '',
      password: '',
      fullName: '',
      email: '',
      accountType: ''
    });
  };

  return (
    <MDBContainer fluid className='d-flex justify-content-center align-items-center min-vh-100' style={{ 
      backgroundImage: `url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp')`,
      backgroundSize: 'cover',
      backgroundPosition: 'center',
      backdropFilter: 'blur(8px)'
    }}>
      <MDBCard className='my-4 w-50' style={{ backdropFilter: 'blur(8px)', backgroundColor: 'rgba(30, 178, 166, 0.8)' }}>
        <MDBCardBody className='text-black d-flex flex-column justify-content-center align-items-center'>
          <h3 className="mb-5 text-uppercase fw-bold text-center"> Registration Form</h3>

          <MDBRow className='w-100'>
            <MDBCol md='12' className="d-flex flex-column align-items-center">
              <MDBInput wrapperClass='mb-4' label='User name' size='lg' id='username' type='text' value={formData.username} onChange={handleChange} />
              <MDBInput wrapperClass='mb-4' label='Password' size='lg' id='password' type='password' value={formData.password} onChange={handleChange} />
              <MDBInput wrapperClass='mb-4' label='Full Name' size='lg' id='fullName' type='text' value={formData.fullName} onChange={handleChange} />
              <MDBInput wrapperClass='mb-4' label='Email Id' size='lg' id='email' type='email' value={formData.email} onChange={handleChange} />

              <div className="mb-4 w-100 d-flex flex-column text-center align-items-center">
                <label className="form-label">Account Type:</label>
                <select className="form-select w-25" id="accountType" value={formData.accountType} onChange={handleChange}>
                  <option value="" disabled>Account type</option>
                  <option value="student">Student</option>
                  <option value="instructor">Instructor</option>
                  {/* <option value="admin">Admin</option> */}
                </select>
              </div>
            </MDBCol>
          </MDBRow>

          <div className="d-flex justify-content-end pt-3 w-100">
            <MDBBtn color='light' size='lg' onClick={handleReset}>Reset all</MDBBtn>
            <MDBBtn className='ms-2' color='warning' size='lg' onClick={handleSubmit}>Submit form</MDBBtn>
          </div>

        </MDBCardBody>
      </MDBCard>
    </MDBContainer>
  );
}

export default Registration;
