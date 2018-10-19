import React from 'react'
import PropTypes from 'prop-types'

const Link = ({ active, children, onClick }) => {
    // If link is active, render children as a normal text. Otherwise, render children inside a link
    if (active) {
        return (<span>{children}</span>)
    }

    return (
        // eslint-disable-next-line
        <a
            href="#"
            onClick={e => {
                e.preventDefault()
                onClick()
            }}
        >
            {children}
        </a>
    )
}

Link.propTypes = {
    active: PropTypes.bool.isRequired,
    children: PropTypes.node.isRequired,
    onClick: PropTypes.func.isRequired
}

export default Link