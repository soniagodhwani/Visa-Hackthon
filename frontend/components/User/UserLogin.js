import React from 'react';
import {KeyboardAvoidingView, Platform, ScrollView, StyleSheet, Text, View} from 'react-native';
import {Button} from 'react-native-elements'
import {HelperText, TextInput} from 'react-native-paper';
import ValidationComponent from 'react-native-form-validator';
import {ConfirmDialog} from "react-native-simple-dialogs";
import {SCREEN_NAME} from "../Navigator";
import {connect} from "react-redux";
import {USER_LOGIN} from "../../actions/type";

class UserLogin extends ValidationComponent{

    constructor(props) {
        super(props);
        this.state = {
            userName: '',
            password: '',
            errors: true,
            dialogVisible: false,
            successDialogVisible: false,
            successMessage: 'Hurray',
            navigation: this.props.navigation
        };
    }



    submitForm = () =>  {
        let data = {
            method: 'POST',
            credentials: 'same-origin',
            mode: 'same-origin',
            body: JSON.stringify({
                "username": this.state.userName,
                "password": this.state.password,
            }),
            headers: {
                'Accept':       'application/json',
                'Content-Type': 'application/json',
                // 'X-CSRFToken':  cookie.load('csrftoken')
            }
        };

        console.log(data);
        return data
    };

    _onSubmit() {
        // Call ValidationComponent validate method
        this.validate({
            firstName: {minlength:2, maxlength:10, required: true},
            // lastName: {minlength:2, maxlength:10, required: true},
            // email: {email: true, required: true},
            // phone: {minlength:8, maxlength:10, numbers: true, required:true},
            // address: {minlength:2, maxlength:30},
            // date: {date: 'MM-DD-YYYY', required: true}
        });
    }

    noErrorMessage = () => {
        this._onSubmit();
        const noError = this.isFieldInError("firstName")===false &&
            this.isFieldInError("lastName")===false &&
            this.isFieldInError("email")===false &&
            this.isFieldInError("date")===false &&
            this.isFieldInError("phone")===false &&
            this.isFieldInError("address")===false;
        console.log(this.getErrorMessages());
        if (noError===false){
            this.setState({dialogVisible: true})
        } else{
            // this.setState({successDialogVisible: true})
        }

        return noError
    };

    theme = {
        colors: "red"
    };

    static cityList = [{
        value: 'New Brunswick',
    }, {
        value: 'Newark',
    }, {
        value: 'Jersey City',
    }];

    static stateList = [{
        value: 'New Jersey',
    }];

    static countryList = [{
        value: 'USA',
    }];

    componentDidMount() {
        console.log("mounted");
    }

    render() {

        console.log("My Props in render", this.props);
        //
        if (this.props.customerId!==null) {
            this.state.navigation.navigate(SCREEN_NAME.MAPS);
        }

        return (
            <KeyboardAvoidingView
                behavior={Platform.OS === "ios" ? "padding" : "height"}
            >
            <ScrollView >
                <View style={{backgroundColor: 'rgba(0,19,255,0.89)',
                    height: 300,
                    width: '100%',
                }}/>

                <View style={styles.container}>
                    <ConfirmDialog
                        title="Oops. You have some errors"
                        message="Are you sure about that?"
                        visible={this.state.dialogVisible}
                        onTouchOutside={() => this.setState({dialogVisible: false})}
                        positiveButton={{
                            title: "Go ahead and rectify",
                            onPress: () => this.setState({dialogVisible: false})
                        }}>

                        <View>
                            <Text>
                                {this.getErrorMessages()}
                            </Text>
                        </View>
                    </ConfirmDialog>

                    <ConfirmDialog
                        title="Profile Successfully Created"
                        message=""
                        visible={this.state.successDialogVisible}
                        onTouchOutside={() => this.setState({successDialogVisible: false})}
                        positiveButton={{
                            title: " Manage Business -> ",
                            onPress: () => {
                                this.setState({successDialogVisible: false});
                                this.state.navigation.navigate(SCREEN_NAME.MAPS)
                            }
                        }}>

                        <View>
                            <Text>
                                {this.state.successMessage}
                            </Text>
                        </View>
                    </ConfirmDialog>



                    <View style={{width:"50%", minWidth: 300, maxHeight: 100, height: 100}}>
                        <TextInput
                            style={{width: '100%'}}
                            label='First Name'
                            ref="userName"
                            defaultValue={this.state.userName}
                            onChangeText={(userName) => {
                                this.setState({userName: userName});
                                this._onSubmit();
                            }}
                            mode="outlined"
                            selectionColor="black"
                            autoCompleteType="name"
                            editable={true}
                            error={this.state.userName!=='' && this.isFieldInError('userName')}
                            value={this.state.userName}
                            // showError={false}
                            theme={{ colors: { placeholder: 'grey', text: 'black', primary: 'black',
                                    underlineColor: 'black', background: 'white'} }}

                        />
                        <HelperText
                            type="error"
                            visible={
                                this.state.firstName!=='' && this.isFieldInError('firstName')
                            }
                            // style={{ marginTop: "-5%"}}
                        >
                           Invalid Name
                        </HelperText>
                    </View>

                    <View style={{width:"50%", minWidth: 300, maxHeight: 100, height: 100}}>
                        <TextInput
                            secureTextEntry={true}
                            style={{width: '100%'}}
                            label='Password'
                            ref="password"
                            defaultValue={this.state.password}
                            onChangeText={(password) => {
                                this.setState({password: password});
                                this._onSubmit();
                            }}

                            mode="outlined"
                            selectionColor="black"
                            autoCompleteType="password"
                            editable={true}
                            error={this.state.password!=='' && this.isFieldInError('password')}
                            value={this.state.password}
                            // showError={false}
                            theme={{ colors: { placeholder: 'grey', text: 'black', primary: 'black',
                                    underlineColor: 'black', background: 'white'} }}

                        />
                        <HelperText
                            type="error"
                            visible={
                                this.state.firstName!=='' && this.isFieldInError('firstName')
                            }
                            // style={{ marginTop: "-5%"}}
                        >
                            Invalid Name
                        </HelperText>
                    </View>


                    <Button
                        title="LOGIN"
                        type="outline"
                        raised= "true"
                        buttonStyle={{marginTop: 30, width:"70%", alignSelf: 'center', height: 50, minWidth: 300}}
                        // titleStyle={{ fontSize: 25, }}
                        // containerStyle={styles.buttonContStyle}
                        // buttonStyle={styles.buttonStyle}
                        onPress={
                            () => this.noErrorMessage()===true && this.props.submitForm(this.submitForm())
                            // ToastAndroid.show('New User Added', ToastAndroid.SHORT) }
                        }
                    />
                </View>
            </ScrollView>
            </KeyboardAvoidingView>
        );
    }


  }


const mapStateToProps = (store) => {
    return {
        customerId: store.queue.customerId
    }
};

const mapDispatchToProps = (dispatch) => ({
    submitForm: (data) => dispatch({
        type: USER_LOGIN,
        data: data
    })
});

export default connect(mapStateToProps, mapDispatchToProps)(UserLogin);



const styles = StyleSheet.create({
container: {
    flex: 1,
    flexDirection: 'column',
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: 'white',
    borderRadius: 30,
    // borderWidth: 1,
    borderColor: 'grey',
    margin: 20,
    shadowColor: 'grey',
    shadowRadius: 30,
    marginTop: '-50%',
    padding: 30,
    // marginBottom: 100
},
title: {
    paddingTop: 20,
    marginBottom: 20,
    fontSize: 20,
    // color: "#192a56",
    fontWeight: "bold",
    letterSpacing: 1,
},
buttonContStyle: {
    marginTop: 20,
    width: "75%",
    maxWidth: 500
},
buttonStyle: {
    // backgroundColor: "#00a8ff",
    // fontStyle: "#fff"
    height: 70,
},
inputStyle: {
    width: "90%",
    height: 60,
}
});
