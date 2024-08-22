import React, { useState } from 'react';
import axios from 'axios';

const AddSection = () => {
  const [sectionName, setSectionName] = useState('');
  const [timeDuration, setTimeDuration] = useState('');
  const [description, setDescription] = useState('');
  const [videoUrl, setVideoUrl] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      await axios.post('http://localhost:8080/addsection', {
        sectionName,
        timeDuration,
        description,
        videoUrl,
      });

      // Reset form fields after successful submission
      setSectionName('');
      setTimeDuration('');
      setDescription('');
      setVideoUrl('');
    } catch (error) {
      console.error('Error submitting form:', error);
    }
  };

  return (
    <div className="container my-5">
      <h2 className="mb-4">Add Section</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="sectionName" className="form-label">
            Section Name
          </label>
          <input
            type="text"
            className="form-control"
            id="sectionName"
            value={sectionName}
            onChange={(e) => setSectionName(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="timeDuration" className="form-label">
            Time Duration
          </label>
          <input
            type="text"
            className="form-control"
            id="timeDuration"
            value={timeDuration}
            onChange={(e) => setTimeDuration(e.target.value)}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="description" className="form-label">
            Description
          </label>
          <textarea
            className="form-control"
            id="description"
            rows="3"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            required
          ></textarea>
        </div>
        <div className="mb-3">
          <label htmlFor="videoUrl" className="form-label">
            Video URL
          </label>
          <input
            type="url"
            className="form-control"
            id="videoUrl"
            value={videoUrl}
            onChange={(e) => setVideoUrl(e.target.value)}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  );
};

export default AddSection;