//import React from 'react';
//import { StyleSheet, Text, View } from 'react-native';
//
//export default function App() {
//  return (
//    <View style={styles.container}>
//      <Text>Open up App.js to start working on your app!</Text>
//    </View>
//  );
//}
//
//const styles = StyleSheet.create({
//  container: {
//    flex: 1,
//    backgroundColor: '#fff',
//    alignItems: 'center',
//    justifyContent: 'center',
//  },
//});

import React from 'react';
import {StyleSheet, View} from 'react-native';
import {FONTS} from "../Fonts";
import QueueCard from "./QueueCard";
import {connect} from "react-redux";

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


class QueueCardList extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            stores: [
                {
                    storeId: '1',
                    storeImage: require('../assets/images/Target.jpeg'),
                    storeName: "TARGET",
                    status: "JOINED QUEUE"
                }
            ]
        }
    }

    render(){
        const joinedQueues = this.props.joinedQueues;
        console.log(joinedQueues);

        return(
            <View style={{backgroundColor: 'white'}}>
                <View style={{flexDirection: 'row', justifyContent: 'space-between'}}>
                    {/*<View style={{backgroundColor: '#ff8800', height: 150, width: '100%', borderBottomLeftRadius: 50,}}/>*/}
                    {/*<View style={{backgroundColor: '#ff8800', height: 150,  width: '50%'}}/>*/}
                </View>

                {joinedQueues.length!==0 &&  Object.entries(joinedQueues).map(([index, store]) => {
                    return (
                        <QueueCard  store={store}/>
                    )
                })}

            </View>

        );

    }

}


const mapStateToProps = (store) => {
    return {
        joinedQueues: store.queue.joinedQueues,
        customerId: store.queue.customerId
    }
};

export default connect(mapStateToProps, null)(QueueCardList);

