import ValidationComponent from "react-native-form-validator";
import {View} from "react-native";
import React from "react";
import MapView, {Marker} from 'react-native-maps';
import QueueCard from "./QueueCard";
import {GET_MERCHANTS} from "../actions/type";
import {connect} from "react-redux";
import {FONTS} from "../Fonts";
import {Button} from "react-native-elements";
import {SCREEN_NAME} from "./Navigator";

class Maps extends ValidationComponent {
    constructor(props) {
        super(props);
        const currentLng= -122.461593;
        const currentLtd= 37.725025;

        this.state = {
            navigation: this.props.navigation,
            region: {
                latitude: currentLtd,
                longitude: currentLng,
                latitudeDelta: 0.0922,
                longitudeDelta: 0.0421,
            },
            merchants: null,
            showOverlay: true,
            currentMerchantIndex: 0,
            currentLng: currentLng,
            currentLtd: currentLtd

        };

        console.log(this.props);
    }

    onMarkerClick(event, index){
        this.setState({
            ...this.state,
            showOverlay: true,
            currentMerchantIndex: index
        });
        console.log("Current updated to ", this.state.currentMerchantIndex)
    }

    componentDidMount() {
        console.log("I just mounted");
        let data = {
            method: 'GET',
            credentials: 'same-origin',
            mode: 'same-origin',

            headers: {
                'Accept':       'application/json',
                'Content-Type': 'application/json',
                // 'X-CSRFToken':  cookie.load('csrftoken')
            }
        };

        this.props.fetchMerchants(data, this.state.currentLng,this.state.currentLtd);
    }

        render() {
            console.log("Merchants", this.props.merchants);
            const merchants = this.props.merchants;

            if (merchants){
                console.log("id",merchants[0].merchant.id);
                console.log(merchants[this.state.currentMerchantIndex]);
            }


        return (

                <View>
                    <MapView
                        ref="map"
                        style={{height: "80%"}}
                        region={this.state.region}
                        onRegionChange={(region) => this.setState({region})}
                        // onLayout={() => { this.mark.showCallout(); }}
                    >
                        {merchants!==null && Object.entries(merchants).map(([index, merchant]) => (
                            <Marker
                                // ref={ref => { this.mark = ref; }}
                                key={index}
                                identifier={index}
                                coordinate={{
                                    latitude: merchant.merchant.latitude,
                                    longitude:  merchant.merchant.longitude
                                }}
                                title={merchant.merchant.merchantName}
                                description={merchant.merchant.merchantName}
                                draggable={false}

                                onPress={(e) => { this.onMarkerClick(e, index)}}
                                // image={require('./assets/images/pin.png')}

                            />
                        ))}

                    </MapView>
                    <View style={{position: "absolute", bottom: "0%", width: '100%',  }}>
                        <View
                        >
                            { merchants &&
                            <QueueCard store={merchants[this.state.currentMerchantIndex]}/>
                            }

                        </View>

                    </View>
                    <View style={{bottom: "-20%", width: '100%',margin: 10 }}>
                        <Button
                            title="VIEW ALL QUEUES YOU HAVE JOINED"
                            type="outline"
                            raised={true}
                            titleStyle={{fontFamily: FONTS.MONTSERRAT_SB}}
                            buttonStyle={{width:"100%", height: 50, borderRadius: 20
                            }}
                            onPress={() => this.state.navigation.navigate(SCREEN_NAME.QUEUE_CARDS)}
                        />
                    </View>

                </View>

        )
    }
}



const mapStateToProps = (store) => {
    return {
        merchants: store.queue.merchants
    }
};

const mapDispatchToProps = (dispatch) => ({
    fetchMerchants: (data, lgd, ltd) => dispatch({
        type: GET_MERCHANTS,
        data: data,
        lgd: lgd,
        ltd: ltd
    })
});

export default connect(mapStateToProps, mapDispatchToProps)(Maps);
