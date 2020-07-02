import React, {Component} from 'react';
import {StyleSheet, View} from 'react-native';
import {NavigationContainer} from "@react-navigation/native";
import {createStackNavigator} from "@react-navigation/stack";
import ContentLoader from "react-native-easy-content-loader";
import {fetchFonts} from "../Fonts";
import UserLogin from "./User/UserLogin";
import Maps from "./Maps";
import QueueCardList from "./QueueCardList";
import QueueCard from "./QueueCard";

const Stack = createStackNavigator();

export const SCREEN_NAME = {
    USER_LOGIN: 'User Login',
    MAPS: 'Merchants Near You',
    QUEUE_CARDS: 'Your Queue Status',
    QUEUE_CARD: 'Queue Card',

};

class Navigator extends Component{

    constructor(props) {
        super(props);
        this.state = {
            loading: true
        }
    }

    componentDidMount() {
        fetchFonts().then(r => {
            console.log("Fonts Loaded");
            this.setState({loading: false})
        });
    }

    render() {
        return(
            <View style={styles.container}>
                <ContentLoader listSize={3} active  loading={this.state.loading} pRows={0} pHeight={0} tHeight={0} avatarStyles={styles.item}>
                <NavigationContainer>
                    <Stack.Navigator>
                        <Stack.Screen name={SCREEN_NAME.USER_LOGIN} component={UserLogin} />
                        <Stack.Screen name={SCREEN_NAME.MAPS} component={Maps} />
                        <Stack.Screen name={SCREEN_NAME.QUEUE_CARDS} component={QueueCardList} />
                        <Stack.Screen name={SCREEN_NAME.QUEUE_CARD} component={QueueCard} />
                    </Stack.Navigator>
                </NavigationContainer>
                </ContentLoader>
            </View>
        )
    }
}


export default Navigator;



const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
  },
      container2: {
    backgroundColor: '#fff',
    alignItems: 'flex-start',
          justifyContent: 'flex-start'
  },
    textView: {
      flex: 1,
        backgroundColor: '#fff',
        justifyContent: 'center',
        alignItems: 'center'
    }
});
