import React, {Component} from 'react'
import './ProductDetail.css'

export default class ProductDetail extends Component {
    render() {
        const isNan = Number(this.props.match.params.id);
        if (isNaN(isNan)) {
            this.props.history.push('/products');
            return '';
        } else {
            const detailItem = Object.values(require('../../../../exercise-2/mockups/data.json'))
                .find(item => item.id == isNan);
            return <form className="form-horizontal" role="form">
                <div id="title" className="form-group">
                    <h2>Product Detail</h2>
                </div>
                <div className="form-group">
                    <label className="col-sm-2 control-label">
                        <h5>Name</h5>
                    </label>
                    <div className="col-sm-10">
                        <input className="form-control" id="focusedInput" type="text" value={detailItem.name} />
                    </div>
                </div>
                <div className="form-group">
                    <label htmlFor="inputPassword" className="col-sm-2 control-label">
                        <h5>Price</h5>
                    </label>
                    <div className="col-sm-10">
                        <input className="form-control" id="disabledInput" type="text" value={detailItem.price} disabled />
                    </div>
                </div>
                <div className="form-group has-success">
                    <label className="col-sm-2 control-label" htmlFor="inputSuccess">
                        <h5>Quantity</h5>
                    </label>
                    <div className="col-sm-10">
                        <input type="text" className="form-control" id="inputSuccess" value={detailItem.quantity} />
                    </div>
                </div>
                <div className="form-group has-warning">
                    <label className="col-sm-2 control-label" htmlFor="inputWarning">
                        <h5>Description</h5>
                    </label>
                    <div className="col-sm-10">
                        <input type="text" className="form-control" id="inputWarning" value={detailItem.desc} />
                    </div>
                </div>
            </form>
        }
    }
}