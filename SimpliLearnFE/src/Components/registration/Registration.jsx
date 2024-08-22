import React from 'react';
import {
  MDBBtn,
  MDBContainer,
  MDBCard,
  MDBCardBody,
  MDBRow,
  MDBCol,
  MDBInput,
  MDBRadio,
}
from 'mdb-react-ui-kit';

function Registration() {
  return (
    <MDBContainer fluid className='d-flex justify-content-center align-items-center min-vh-100' style={{ 
      backgroundImage: `url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp')`,
      backgroundSize: 'cover',
      backgroundPosition: 'center',
      backdropFilter: 'blur(8px)'
    }}>
      <MDBCard className='my-4 w-50' style={{ backdropFilter: 'blur(8px)', backgroundColor: 'rgba(255, 255, 255, 0.8)' }}>
        <MDBCardBody className='text-black d-flex flex-column justify-content-center align-items-center'>
          <h3 className="mb-5 text-uppercase fw-bold text-center"> Registration Form</h3>

          <MDBRow className='w-100'>
            <MDBCol md='12' className="d-flex flex-column align-items-center">
              <MDBInput wrapperClass='mb-4' label='User name' size='lg' id='form1' type='text' />
              <MDBInput wrapperClass='mb-4' label='Password' size='lg' id='form2' type='text' />
              <MDBInput wrapperClass='mb-4' label='Full Name' size='lg' id='form3' type='text' />
              <MDBInput wrapperClass='mb-4' label='Email Id' size='lg' id='form4' type='text' />
              {/* <MDBInput wrapperClass='mb-4' label='Is Admin' size='lg' id='form5' type='text' /> */}


              <div className="mb-4 w-100">
                <label className="form-label">Account Type:</label>
                <select className="form-select" id="form7" aria-label="Account Type">
                  <option value="" disabled selected>Select account type</option>
                  <option value="student">Student</option>
                  <option value="instructor">Instructor</option>
                  <option value="admin">Admin</option>
                </select>
              </div>
            </MDBCol>
          </MDBRow>

          <div className="d-flex justify-content-end pt-3 w-100">
            <MDBBtn color='light' size='lg'>Reset all</MDBBtn>
            <MDBBtn className='ms-2' color='warning' size='lg'>Submit form</MDBBtn>
          </div>

        </MDBCardBody>
      </MDBCard>
    </MDBContainer>
  );
}

export default Registration;
