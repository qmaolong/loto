var Ali = Ali || {};
Ali.QTMainJSLoaded = true;
$(function(){
    $.post('/qthome/info',function(data){

        var userRole = '';

        if(!data || data == null){

        } else {
            userRole = data.userRole;
        }

        var isSuperAmdmin = userRole == "SuperAdmin" ? true : false;
        var isAdmin = userRole == "Admin" ? true : false;
        var isJiedai = userRole == "Jiedai" ? true : false;
        var isPunisher = userRole == "Punisher" ? true : false;
        var isQTMember = userRole == "QTMember" ? true : false;

        var isNotReg = isSuperAmdmin == false && isAdmin == false && isJiedai == false && isPunisher == false && isQTMember == false;

        var isShowMission = true;

        var navTrObj = $('.system-top-nav-tr');
        if (isNotReg == true) {
            navTrObj.append('<td><a class="header-nav waiting-nav" href="/missionhall/waitingMissions">任务中心</a> </td>');
            navTrObj.append('<td><a class="header-nav qtreg-nav" href="/qthome/qtreg">入会登记</a> </td>');
        } else {

        }

        if (isSuperAmdmin == true) {
            navTrObj.append('<td><a class="header-nav" href="/loginuseradmin/index">权限管理</a></td>');
        }
        if (isSuperAmdmin == true || isAdmin == true || isJiedai == true) {
            navTrObj.append('<td><a class="header-nav" href="/qtmemberadmin/index">会员管理</a> </td>');
        }
        if (isSuperAmdmin == true) {
            //navTrObj.append('<td><a class="header-nav" href="/qtlinkadmin/index">链接中心</a> </td>');
            navTrObj.append('<td><a class="header-nav mission-admin-nav" href="/missionadmin/missionOpLogs">任务管理</a> </td>');
        }

        if (isAdmin == true || isJiedai == true) {
            navTrObj.append('<td><a class="header-nav" href="/qtlinkadmin/index">链接中心</a> </td>');
        }

        if (isQTMember == true && isShowMission == true) {
            navTrObj.append('<td><a class="header-nav waiting-nav" href="/missionhall/waitingMissions">任务中心</a> </td>');
            navTrObj.append('<td><a class="header-nav comment-nav" href="/CreditAdmin/index">评分管理</a> </td>');
        }

        if (isSuperAmdmin == true || isAdmin == true || isPunisher == true) {
            //navTrObj.append('<td><a class="header-nav" href="/qtpunishadmin/addPunish">添加处罚</a> </td>');
            navTrObj.append('<td><a class="header-nav punish-nav" href="/qtpunishadmin/queryPun">投诉处罚</a> </td>');
            navTrObj.append('<td><a class="header-nav" href="/Referral/applyAdmin">推荐费管理</a> </td>');
            //navTrObj.append('<td><a class="header-nav" href="/qtpunishadmin/searchPun">查看处罚</a> </td>');
        } else if (isQTMember == true) {
            navTrObj.append('<td><a class="header-nav punish-nav" href="/qtpunishadmin/queryPun">我的公会</a> </td>');
            //navTrObj.append('<td><a class="header-nav" href="/qtpunishadmin/searchPun">查看处罚</a> </td>');
        } else {
            navTrObj.append('<td><a class="header-nav" href="/qtpunishadmin/searchPun">查看处罚</a> </td>');
        }



        if (isQTMember == true && isShowMission == true) {
            navTrObj.append('<td><a class="header-nav userinfo-nav" href="/UserInfo/myInfo">用户中心</a> </td>');
        }

        if (isSuperAmdmin == true) {

        } else {
            navTrObj.append('<td><a id="helpcenternav" class="header-nav" href="/helpcenter/index">帮助中心</a> </td>');
        }


        if (isSuperAmdmin == true || isAdmin == true || (isQTMember == true && isShowMission == true)) {

        } else {
            navTrObj.append('<td><a class="header-nav" href="/qthome/video">教程</a> </td>');
        }

        navTrObj.append('<td><a  target="_blank" class="header-nav" href="http://www.sutuijingling.com">论坛</a> </td>');

        Ali.selectNavObjFunc();

    });

});