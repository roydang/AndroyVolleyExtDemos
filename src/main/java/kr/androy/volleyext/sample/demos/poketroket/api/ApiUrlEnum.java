package kr.androy.volleyext.sample.demos.poketroket.api;


public class ApiUrlEnum {
	public static final String PHOTOINFRA_URL = "http://static.poketroket.co";
	public static final String PHOTOINFRA_URL_BETA = "http://beta.static.poketroket.co";

    public static final String GOOGLE_STATIC_MAP_URL = "http://maps.google.co.kr/maps/api/staticmap?center=%s,%s&zoom=%s&size=640x640&" +
            "format=png&maptype=roadmap&mobile=false&sensor=false&hl=ko"; // free 버전일경우 최대640x640

	public enum POKETROKET_URL {
         // 로그인관련(인증)
         AUTH_ISSUE_TEMP_PASSWORD	    ("/auth/temporarypassword.nhn"),
         AUTH_LOGIN					    ("/auth/login.nhn"),
         AUTH_COMPLETE				    ("/auth/complete.nhn"),
         AUTH_LOGOUT				    ("/auth/logout.nhn"),

         // 회원가입
         MEMBER_REGISTER			    ("/member/register.nhn"),
         MEMBER_REGISTER_PROFILE_ADD    ("/member/profile.nhn"),
         MEMBER_WITHDRAW                ("/member/secede.nhn"),
         MEMBER_USERINFO			    ("/member/userinfo.nhn"),
         MEMBER_PUSH_OPTION			    ("/member/pushoption.nhn"),
         MEMBER_PUSH_OPTION_TYPE		("/member/pushoptionByType.nhn"),
         MEMBER_PUSH_OPTION_ME			("/member/pushoptionByMe.nhn"),
         MEMBER_PUSH_OPTION_FRIEND		("/member/pushoptionByFriend.nhn"),
         MEMBER_UPLOAD				    ("/member/upload.nhn"),
         MEMBER_UPDATE				    ("/member/update.nhn"),
         MEMBER_PASSWORD			    ("/member/password.nhn"),
         MEMBER_LOCATIONAGREE			("/member/locagree.nhn"),
         
		 // 프로필 관련 
		 PROFILE_INDEX				    ("/profile/index.nhn"),
		 PROFILE_BACKGROUND			    ("/profile/background.nhn"),
		 PROFILE_FEED				    ("/profile/feeds.nhn"),
		 PROFILE_REPORT				    ("/profile/report.nhn"),
		 PROFILE_GALLERY				("/profile/gallery.nhn"),
		 
		 // 뱃지
		 BADGE_BADGE_INFO			    ("/badge/badgeInfo.nhn"),
		 BADGE_BADGE_INFO_DETAIL	    ("/badge/badgeInfoDetail.nhn"),
		 BADGE_SETBADGE_INFO		    ("/badge/setBadgeInfo.nhn"),
		 BADGE_GROUP_LIST			    ("/badge/groupList.nhn"),
		 BADGE_CHOICE_LIST			    ("/badge/choicelist.nhn"),
		 BADGE_CHOICE_ADD			    ("/badge/choiceadd.nhn"),
		 BADGE_CHOICE_UPDATE		    ("/badge/choiceupdate.nhn"),
		 BADGE_CHOICE_SET			    ("/badge/choiceset.nhn"),
		 BADGE_CHOICE_DELETE		    ("/badge/choicedelete.nhn"),
		 BADGE_CHOICE_REMOVE		    ("/badge/choiceremove.nhn"),
		 BADGE_ITEM				        ("/badge/item.nhn"),
		 BADGE_ADD_ITEM				    ("/badge/addItem.nhn"),
		 BADGE_DELETE_ITEM			    ("/badge/deleteItem.nhn"),
		 BADGE_POI					    ("/badge/poi.nhn"),

         // 이벤트
		 BADGE_EVENT_LIST			    ("/badge/eventList.nhn"),
		 BADGE_EVENT_INFO			    ("/badge/eventInfo.nhn"),
		 BADGE_EVENT_JOIN			    ("/badge/eventJoin.nhn"),
		 BADGE_EVENT_RANKING		    ("/badge/eventRanking.nhn"),
		 BADGE_EVENT_BOARD_LIST		    ("/badge/eventBoardList.nhn"),
		 BADGE_EVENT_BOARD_ADD		    ("/badge/addEventBoard.nhn"),

		 // 피드
		 FEED_NEWS					    ("/feed/news.nhn"),
		 FEED_WRITE						("/feed/write.nhn"),
		 FEED_IMAGE_ADD					("/feed/imgadd.nhn"),
		 FEED_IMAGE_DEL					("/feed/imgdel.nhn"),
		 FEED_VIEW						("/feed/view.nhn"),
		 FEED_UPDATE					("/feed/update.nhn"),
		 FEED_DELETE					("/feed/delete.nhn"),
		 FEED_STREAM					("/feed/stream.nhn"),
		 FEED_LIKE						("/feed/like.nhn"),
		 FEED_COMMENT					("/feed/comment.nhn"),
		 FEED_GALLERY					("/feed/gallery.nhn"),
		 
		 // 노티
		 NOTIBYTYPE_NOTICES				("/notiByType/notices.nhn"),
		 NOTIBYTYPE_UNREAD		    	("/notiByType/unread.nhn"),
		 NOTIBYTYPE_UNREAD_ALL		    ("/notiByType/unreadAll.nhn"),
		 NOTIBYTYPE_ALLREAD			    ("/notiByType/allread.nhn"),
		 
		 NOTI_ALLREAD				    ("/noti/allread.nhn"),
		 NOTI_UNREAD				    ("/noti/unread.nhn"),
		 
		 // 친구
         FRIENDS_FRIENDSCOMBINE         ("/friend/friendscombine.nhn"),
         FRIENDS_OTHERS                 ("/friend/friends.nhn"),
		 FRIENDS_BLOCKES			    ("/friend/blockes.nhn"),
		 FRIENDS_BLOCK				    ("/friend/block.nhn"),
         FRIENDS_ACCEPT				    ("/friend/accept.nhn"),
         FRIENDS_RECOMMEND			    ("/friend/recommend.nhn"),
         FRIENDS_SEARCH				    ("/friend/search2.nhn"),
         FRIENDS_SEARCH_MYFRIENDS       ("/friend/searchmy.nhn"),
         FRIENDS_ADD				    ("/friend/add.nhn"),
		 FRIENDS_INVITE				    ("/friend/invite.nhn"),
		 FRIENDS_CANCEL				    ("/friend/cancel.nhn"),
		 FRIENDS_SEVER				    ("/friend/sever.nhn"),
		 
		 // 랭킹
		 RANKING_SEARCH				    ("/ranking/search.nhn"),
		 
		 // activity
		 ACTIVITY_ADD				    ("/activity/add.nhn"),
		 ACTIVITY_IMAGEADD			    ("/activity/imgadd.nhn"),
		 ACTIVITY_IMAGE_DELETE		    ("/activity/imgdel.nhn"),
		 ACTIVITY_VIEW				    ("/activity/view.nhn"),
		 ACTIVITY_TRACK				    ("/activity/track.nhn"),
		 ACTIVITY_UPDATE			    ("/activity/update.nhn"),
		 ACTIVITY_LIKE				    ("/activity/like.nhn"),
		 ACTIVITY_COMMENT			    ("/activity/comment.nhn"),
		 ACTIVITY_UNCOMPLETES		    ("/activity/uncompletes.nhn"),
		 ACTIVITY_CONTINUOUS		    ("/activity/continuous.nhn"),
		 ACTIVITY_COMPLETE			    ("/activity/complete.nhn"),
		 ACTIVITY_LIFE				    ("/activity/life.nhn"),
		 ACTIVITY_STREAM			    ("/activity/stream.nhn"),
		 ACTIVITY_ABUSESTANDARD		    ("/activity/abusestandard.nhn"),
         ACTIVITY_SHARED			    ("/activity/shared.nhn"),
         
         // common - item 뱃지발급시 
         COMMON_REPORT				    ("/common/report.nhn"),
         
         //내 위치 공개
         LOCATION_CURRENT ("/loc/current.nhn"),
         LOCATION_SEARCH ("/loc/search.nhn"),
         LOCATION_OPEN("/loc/open.nhn"),
         LOCATION_STATUS("/loc/status.nhn"),

         // 이벤트용 및 공지용 팝업관련
         EVENT_NOTICE_POPUP("/auth/modal.nhn");
          

		 private String completeUrl;

		 private POKETROKET_URL(String url) {
			 StringBuilder sb = new StringBuilder();

//             sb.append(PRApplication.context.getResources().getString(R.string.url_apiserver)).append(url);

             this.completeUrl = sb.toString();
		 }

		 public String getURL() {	
			return completeUrl;
		 }
	 }

}
