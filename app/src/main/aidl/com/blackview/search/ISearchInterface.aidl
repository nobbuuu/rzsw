// ISearchInterface.aidl
package com.blackview.search;
// Declare any non-default types here with import statements

interface ISearchInterface {

    void onTouchMotionEvent(in MotionEvent ev);
    void onAttachedToWindow();

    void onDetachedFromWindow();

    void onActivityResume();

    void onActivityPause();

    void onNavKeyEvent(int keyCode);

}