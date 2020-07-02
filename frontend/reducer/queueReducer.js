import {FETCHED_MERCHANTS, JOINED_QUEUE, SELECT_BRAND, SUCCESSFUL_LOGIN} from "../actions/type";

const INITIAL_STATE = {
    customerId: null,
    merchants: null,
    joinedQueues: []
};

export const queueReducer = (state = INITIAL_STATE, action) => {

    switch (action.type) {
        case SUCCESSFUL_LOGIN:
            return {
                ...state,
                customerId: action.customerId
            };
        case FETCHED_MERCHANTS:
            return {
                ...state,
                merchants: action.response.lstMerchant
            };
        case JOINED_QUEUE:
            return {
                ...state,
                joinedQueues: state.joinedQueues.concat(action.response.customerQueueRelation)
            };
        default:
            return state
    }
};

