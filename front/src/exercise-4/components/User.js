import React from 'react';

const User = (props) => {
    const input = props.match.params.user;
    const num = Number(input);
    if (!isNaN(num) || input == "about") {
        return (
            <div>
                User profile page.
            </div>
        );
    } else {
        props.history.push('/error/nonNumber');
        return '';
    }
};

export default User;