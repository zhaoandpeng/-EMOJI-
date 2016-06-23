

var serverip = "192.168.3.190";

var serverport = 8906;

var mSelfUserId;

var dwFlags = ANYCHAT_RECORD_FLAGS_VIDEO+ 
			  ANYCHAT_RECORD_FLAGS_AUDIO + 
			  ANYCHAT_RECORD_FLAGS_MIXVIDEO +
			  ANYCHAT_RECORD_FLAGS_MIXAUDIO+
			  ANYCHAT_RECORD_FLAGS_LOCALCB+  //启动回调
			  ANYCHAT_RECORD_FLAGS_ABREAST;
//登录服务器
function initThing(){
	checksdk();
	initParam();
	loginServer();
	getVideoDevice()
}



























/**以下是对视频见证相关事件的处理**/

//--------------------------------------现场面签部分----------------------------------
//获取视频设备并选择对应设备进行图像显示
function getVideoDevice(){
	var CAMERA_COUNT = BRAC_EnumDevices(1);
	for(i=0;i<CAMERA_COUNT.length;i++){
		if(i==0){
			BRAC_SetUserStreamInfo(mSelfUserId, i, BRAC_SO_LOCALVIDEO_DEVICENAME,CAMERA_COUNT[i]);
			BRAC_SetVideoPosEx(mSelfUserId, document.getElementById("search"), "AnyChatLocalVideoDiv"+i,i);// 
			BRAC_UserCameraControlEx(mSelfUserId,1,i,0, "");
			BRAC_UserSpeakControl(mSelfUserId, 1);
		}else if(i==1){
			BRAC_SetUserStreamInfo(mSelfUserId, i, BRAC_SO_LOCALVIDEO_DEVICENAME,CAMERA_COUNT[i]);
			BRAC_SetVideoPosEx(mSelfUserId, document.getElementById("search2"), "AnyChatLocalVideoDiv"+i,i);// 
			BRAC_UserCameraControlEx(mSelfUserId,1,i,0, "");
			BRAC_UserSpeakControl(mSelfUserId, 1);
		}
	}
}





//检测视频播放插件
function checksdk(){
	var NEED_ANYCHAT_APILEVEL = '0';
	var ERRORCODE = BRAC_InitSDK(NEED_ANYCHAT_APILEVEL);
	if(ERRORCODE==GV_ERR_SUCCESS){
		return;
	}
}

function initParam(){
	// 静音检测
	BRAC_SetSDKOption(BRAC_SO_NETWORK_P2PPOLITIC, 1);
	// 回音消除
	BRAC_SetSDKOption(BRAC_SO_AUDIO_ECHOCTRL, 1);
	// 噪音抑制
	BRAC_SetSDKOption(BRAC_SO_AUDIO_NSCTRL, 1);
	// 自动增益
	BRAC_SetSDKOption(BRAC_SO_AUDIO_AGCCTRL, 1);
	// 码率150*1000
    BRAC_SetSDKOption(BRAC_SO_LOCALVIDEO_BITRATECTRL, 100000);
    // 分辨率640*480 352*288 320*240 176*144
    BRAC_SetSDKOption(BRAC_SO_LOCALVIDEO_WIDTHCTRL, 320);
    BRAC_SetSDKOption(BRAC_SO_LOCALVIDEO_HEIGHTCTRL, 240);
    // 帧率
    BRAC_SetSDKOption(BRAC_SO_LOCALVIDEO_FPSCTRL, 15);
    //关闭网络断开后自动重新连接功能
    BRAC_SetSDKOption(BRAC_SO_NETWORK_AUTORECONNECT,0); 
    //
    BRAC_SetSDKOption(BRAC_SO_RECORD_TMPDIR, "E:\\store");//来设置录像文件保存路径；
    //参数设置生效
    BRAC_SetSDKOption(BRAC_SO_LOCALVIDEO_APPLYPARAM, 1);
}

//登录
function loginServer(){
	BRAC_Connect(serverip, serverport);
	BRAC_Login("LUCK","", 0);
	BRAC_EnterRoom(10000,"",0);
}

//视频录制
function startVideo(){
	BRAC_StreamRecordCtrlEx(mSelfUserId, 1, dwFlags, 1, "");
}

function endVideo(){
	BRAC_StreamRecordCtrlEx(mSelfUserId, 0, dwFlags, 1, "");
}