import {StyleSheet} from 'react-native';
import {max} from 'react-native-reanimated';

const style = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: 60,
  },
  text: {
    fontSize: 23,
    textAlign: 'center',
  },
  card_container: {
    backgroundColor: '#FFF9FB',
  },
  footer: {
    height: 100,
    backgroundColor: '#1A1F71',
  },

  safeArea: {
    flex: 1,
  },
  fixBackground: {
    backgroundColor: '#1A1F71',
    position: 'absolute',
    bottom: 0,
    right: 0,
    left: 0,
    height: 20,
    zIndex: -1000,
  },
});

export default style;
