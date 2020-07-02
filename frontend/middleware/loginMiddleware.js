import {
    FETCHED_MERCHANTS,
    GET_MERCHANTS,
    JOINED_QUEUE,
    REQUEST_JOIN,
    SUCCESSFUL_LOGIN,
    USER_LOGIN
} from "../actions/type";
import routes from '../routes'

export const loginMiddleware = store => next => action => {
    console.log("I'm in Login Middleware");

    switch (action.type){
        case USER_LOGIN:
            return fetch(routes.URL + routes.LOGIN, action.data)
                .then((response) => response.json())
                .then((responseJson) => {
                    let str = JSON.stringify(responseJson);
                    console.log(responseJson);
                    store.dispatch(
                        {
                            type: SUCCESSFUL_LOGIN,
                            customerId: responseJson.userProfile.id
                        }
                    );

                    return responseJson;
                })
                .catch((error) => {
                    console.error(error);
                });
        case GET_MERCHANTS:
            return fetch(routes.URL + routes.MERCHANTS + "/" + action.lgd + "/" + action.ltd, action.data)
                .then((response) => response.json())
                .then((responseJson) => {
                    let str = JSON.stringify(responseJson);
                    console.log(responseJson);
                    store.dispatch(
                        {
                            type: FETCHED_MERCHANTS,
                            response: responseJson
                        }
                    );

                    return responseJson;
                })
                .catch((error) => {
                    console.error(error);
                });
        case REQUEST_JOIN:
            const {customerId, queueId, data} = action;
            return fetch(routes.URL + routes.JOIN_QUEUE + "/" + customerId + "/" + queueId, data)
                .then((response) => response.json())
                .then((responseJson) => {
                    let str = JSON.stringify(responseJson);
                    console.log(responseJson);
                    store.dispatch(
                        {
                            type: JOINED_QUEUE,
                            response: responseJson
                        }
                    );

                    return responseJson;
                })
                .catch((error) => {
                    console.error(error);
                });
        default:
            return next(action);
    }
    next(action);

};
