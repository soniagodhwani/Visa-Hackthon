import {combineReducers} from 'redux';
import {queueReducer} from "./queueReducer";

const INITIAL_STATE = {
    
};

const reducer = (state = INITIAL_STATE, action) => {

    switch (action.type) {
        default:
            return state
    }
};

export default combineReducers({
    root: reducer,
    queue: queueReducer
});

