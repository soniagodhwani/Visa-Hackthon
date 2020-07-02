import * as Font from "expo-font";

const ASSETS_DIR = './assets/fonts/';

export const FONTS = {
    MONTSERRAT_SB : 'Montserrat-SemiBold',
};

export const fetchFonts = async () => {
    await Font.loadAsync(
        {
            [FONTS.MONTSERRAT_SB]: require(ASSETS_DIR + 'Montserrat-SemiBold.ttf'),
            /** LIST ALL YOUR FONTS HERE **/

        }
    ).then(r => (console.log("Fonts have been loaded")));
};
