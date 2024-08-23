import React, { useState } from 'react';

const AddCourse = () => {
    const [courseName, setCourseName] = useState('');
    const [description, setDescription] = useState('');
    const [instructorName, setInstructorName] = useState('');
    const [price, setPrice] = useState('');
    const [technology, setTechnology] = useState('');
    const [tag, setTag] = useState('');
    const [videoUrl, setVideoUrl] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        const courseData = {
            courseName,
            description,
            instructorName,
            price,
            technology,
            tag,
            videoUrl
        };

        const response = await fetch('http://localhost:8080/addcourse', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(courseData)
        });

        if (response.ok) {
            console.log('Course added successfully!');
        } else {
            console.error('Failed to add course.');
        }
    };

    return (
        <form onSubmit={handleSubmit} className='container'>
            <div className='mb-3'>
                <label className='form-label'>Course Name:</label>
                <input type='text' className='form-control' value={courseName} onChange={(e) => setCourseName(e.target.value)} required />
            </div>
            <div className='mb-3'>
                <label className='form-label'>Description:</label>
                <textarea className='form-control' value={description} onChange={(e) => setDescription(e.target.value)} required></textarea>
            </div>
            <div className='mb-3'>
                <label className='form-label'>Instructor Name:</label>
                <input type='text' className='form-control' value={instructorName} onChange={(e) => setInstructorName(e.target.value)} required />
            </div>
            <div className='mb-3'>
                <label className='form-label'>Price:</label>
                <input type='number' className='form-control' value={price} onChange={(e) => setPrice(e.target.value)} required />
            </div>
            <div className='mb-3'>
                <label className='form-label'>Technology:</label>
                <input type='text' className='form-control' value={technology} onChange={(e) => setTechnology(e.target.value)} required />
            </div>
            <div className='mb-3'>
                <label className='form-label'>Tag:</label>
                <input type='text' className='form-control' value={tag} onChange={(e) => setTag(e.target.value)} required />
            </div>
            <div className='mb-3'>
                <label className='form-label'>Card Image URL:</label>
                <input type='url' className='form-control' value={videoUrl} onChange={(e) => setVideoUrl(e.target.value)} required />
            </div>
            <button type='submit' className='btn btn-primary'>Add Course</button>
        </form>
    );
};

export default AddCourse;