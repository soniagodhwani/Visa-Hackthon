import React from "react";
import {Card, Icon, Text} from "react-native-elements";
import {FONTS} from "../Fonts";
import {Image, StyleSheet, TouchableOpacity, View} from "react-native";
import {REQUEST_JOIN, USER_LOGIN} from "../actions/type";
import {connect} from "react-redux";


class QueueCard extends React.Component {
    constructor(props) {
        super(props);
    }

    joinQueue(queueId){
        console.log("Joining Queue with ID " + queueId);
        let data = {
            method: 'POST',
            credentials: 'same-origin',
            mode: 'same-origin',
            body: JSON.stringify({
            }),
            headers: {
                'Accept':       'application/json',
                'Content-Type': 'application/json',
                // 'X-CSRFToken':  cookie.load('csrftoken')
            }
        };

        console.log(data);
        this.props.joinQueue(queueId, data, this.props.customerId);
    }

    render() {
        const store = this.props.store;
        const joinedQueues = this.props.joinedQueues;
        console.log(store);
        console.log(joinedQueues);

        return(
            <Card title={store.merchant.merchantName}
                  containerStyle={styles.card}
                  titleStyle={{
                      textTransform: 'uppercase',
                      fontFamily: FONTS.MONTSERRAT_SB,
                  }}
            >
                <View style={{flexDirection:'row', justifyContent:'center', alignItems:'center'}}>
                    <View style={{ justifyContent:'space-between', alignItems:'center', margin: 10}}>

                        {/*<Image style={{width:100, height: 100,borderRadius: 15}} source={store.storeImage} />*/}
                        <Text style={{
                            marginTop: 10,
                            fontSize: 15,
                            textTransform: 'uppercase',
                            fontFamily: FONTS.MONTSERRAT_SB,
                            color: 'grey'
                        }}>
                            Approx Wait Time
                        </Text>
                        <View style={{flex: 1, flexDirection: 'row'}}>


                                { store.current_waitTime === 0 ?

                                    <Text style={{...styles.card_left_text,
                                        marginTop: 10,
                                        color: 'green',
                                        textTransform: 'uppercase',
                                        fontFamily: FONTS.MONTSERRAT_SB,
                                        fontSize: 14
                                    }}>
                                    'Available Immedietly'
                                    </Text>

                                    :

                                    <Text style={{...styles.card_left_text,
                                        marginTop: 10,
                                        textTransform: 'uppercase',
                                        fontFamily: FONTS.MONTSERRAT_SB
                                    }}>
                                            {store.current_waitTime} "mins"
                                    </Text>

                                }

                        </View>


                    </View>

                    <View style={{flexDirection:'column',  alignItems:'center', margin: 10}}>
                        <TouchableOpacity style={{...styles.tag_view}} onPress={() => this.joinQueue(store.merchant.queueId)}>
                            <View style={{
                                borderRadius: 10,
                                backgroundColor: '#00daff',
                                marginBottom: 10,
                                width: '100%',
                                padding: 10,

                            }}>
                                <Text style={{color: 'black',  textTransform: 'uppercase',
                                    fontFamily: FONTS.MONTSERRAT_SB, letterSpacing: 3}}>
                                    JOIN QUEUE
                                </Text>
                            </View>
                        </TouchableOpacity>



                        <View style={{
                            borderRadius: 10,
                            backgroundColor: '#00ff89',

                            width: '100%',
                            padding: 10,

                        }}>
                            <Text style={{color: 'black',  textTransform: 'uppercase',
                                fontFamily: FONTS.MONTSERRAT_SB, letterSpacing: 3}}>SEE OFFERS</Text>
                        </View>
                        {/*<Text style={{...styles.card_labels}}>Actual Price</Text>
                                    <Text style={{...styles.card_labels}}>Total Bill</Text>
                                    <Text style={{...styles.card_labels}}>Total Profit</Text>*/}
                    </View>
                    {/*<View style={{ justifyContent:'space-between', alignItems:'center',marginLeft:"-5%"}}>
                                    <Text style={{...styles.cost, textDecorationLine: 'line-through', color: 'grey'}}>
                                        <RuppeeSign/>
                                        <NumberFormat numberString= {this.state.order.total_cost}/>
                                    </Text>
                                    <Text style={styles.cost}>
                                        <RuppeeSign/>
                                        <NumberFormat numberString= {this.state.order.total_bill}/>
                                    </Text>
                                    <Text style={{...styles.cost, color: "#4b9952"}}>
                                        <RuppeeSign/>
                                        <NumberFormat numberString={this.state.order.estimated_profit}/>
                                    </Text>
                                </View>*/}
                </View>

            </Card>
        )
    }
}


const mapStateToProps = (store) => {
    return {
        joinedQueues: store.queue.joinedQueues,
        customerId: store.queue.customerId
    }
};

const mapDispatchToProps = (dispatch) => ({
    joinQueue: (queueId, data, customerId) => dispatch({
        type: REQUEST_JOIN,
        data: data,
        queueId: queueId,
        customerId: customerId
    })
});

export default connect(mapStateToProps, mapDispatchToProps)(QueueCard);


const styles = StyleSheet.create({
    card:{
        // backgroundColor:'rgba(213, 229, 243, 1)',
        borderWidth:0,
        borderRadius:20,
        // marginTop: '-15%',
        shadowColor: 'grey',
        shadowRadius: 20,
        width: '90%',
        alignSelf: 'center'
    },

    card_left_text:{
        // font: "Roboto",
        fontFamily: FONTS.MONTSERRAT_SB,
        paddingBottom: "4%",
        fontWeight: "700",
        fontSize: 25
    },
    card_labels:{
        fontFamily: FONTS.MONTSERRAT_SB,
        paddingBottom: 20,
        marginRight: 5
    },
    cost:{
        // fontFamily: "Montserrat-SemiBold",
        // fontWeight: "bold",
        fontSize: 20,
        fontWeight: "bold",
        paddingBottom: 20
    }
});

