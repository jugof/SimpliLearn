import React from 'react'

const Title = ({ subtitle ,title }) => {
  return (
    <div>
      <div id='heading'>
        <h3>{subtitle}</h3>
        <h>{title}</h>
      </div>
    </div>
  )
}

export default Title
