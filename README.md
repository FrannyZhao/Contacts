# Contacts for Android
This is an application shows personal information of contacts. 
[Demo video](https://v.youku.com/v_show/id_XMzk2MzAyMzY0NA==.html)

## Code structure
![image](https://raw.githubusercontent.com/FrannyZhao/Contacts/master/demo.png)
The head part is a horizontal recyclerview, which can auto locate the selected item:
* OnItemClickedListener is called when user click the avartar;
* OnSelectedPositionChangedListener is called when the avartars stop scrolling after user swiped left or right.
The body part is a vertical viewpager, OnPageChangeListener is called when user swipe up or down.

## Version
1.0

## Todo
Add unit test;
Improve performance.
