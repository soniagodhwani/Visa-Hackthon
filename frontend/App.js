import React from 'react';
import Navigator from "./components/Navigator";
import {Provider} from 'react-redux';
import {applyMiddleware, createStore} from 'redux';
import rootReducer from './reducer/root';
import {loginMiddleware} from "./middleware/loginMiddleware";


const middleware = applyMiddleware(
    loginMiddleware
);

const store = createStore(rootReducer, middleware);

export default function App() {

    return (
        <Provider store = { store }>
            <Navigator/>
        </Provider>
    )
}
