import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
// import App from './components/App';
import CustomLayout from './components/Layout';
import registerServiceWorker from './registerServiceWorker';
import renderSampleApp from './sample/index.js';

// ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<CustomLayout />, document.getElementById('root'));
registerServiceWorker();

// renderSampleApp();
