
var TM = TM || {};
TM.widget = TM.widget || {};


var getCacheScript=function(url,callback){if(TM.hasCookie){}else if(url.indexOf('?')>=0){url+="&_eu="+TM.sessionUid;}else{url+="?_eu="+TM.sessionUid;}
    callback=callback||function(){}
    $.ajax({url:url,dataType:"script",cache:true,success:callback});}
TM.gcs=getCacheScript;jQuery.getScript=TM.gcs;$.getScript=TM.gcs;TM.helpCenter=TM.helpCenter||{};TM.HC=TM.helpCenter;var me=TM.HC;

me.loadOneArticle=function(id){$.get('/helpcenter/article?id='+id,function(data){if(!data){me.container.html('<div style="margin:25px;margin-bottom:15px;">暂无相关记录</div>');return;}
    me.headTitle.html(data.name+'&nbsp;&nbsp;&nbsp;<a target="_blank" style="font-size:12px;color:rgb(79, 143, 173);font-weight: normal;" href="/local/tmhelparticles/'+data.id+'">编辑</a>');me.container.html(data.body);})}
me.bindListeners=function(){me.level2s.click(function(){var oThis=$(this);var level2Id=oThis.attr('level2Id');var actCls='rigth-small-icon';me.headTitle.text(oThis.text());me.loadArticles('/HelpCenter/listLevel2Articles',{level2Id:level2Id});me.level2s.find('.'+actCls).removeClass(actCls);oThis.find('em').addClass(actCls);})
    me.searchBtn.click(function(){me.doSearch();});me.inputEditor.keydown(function(e){if(e.keyCode==13){me.doSearch();}})
    me.inputEditor.focus(function(){me.inputTip.hide();})
    me.inputEditor.blur(function(){if(me.inputEditor.val().isBlank()){me.inputTip.show();}else{}});}
me.doSearch=function(){var word=me.inputEditor.val().trim();me.loadArticles('/HelpCenter/listSearchArticles',{'word':word});me.headTitle.text('"'+word+'"的搜索结果');}
me.loadArticles=function(url,params){TM.HC.page.tmpage({currPage:1,pageSize:10,pageCount:1,selfPageSizeArray:[10],ajax:{param:params,on:true,dataType:'json',url:url,callback:function(data){me.renderTable(data);}}});}

TM.HC.renderTable=function(tmres){var container=me.container;if(!tmres||!tmres.isOk||tmres.res.length==0){me.container.html('<div style="margin:25px;margin-bottom:15px;">暂无相关记录</div>');return;}
    me.container.empty();me.container.append(me.tmpl.tmpl(tmres.res));}
$(function(){$.fn.extend({tmpage:function(param){init(param,$(this));return $(this);}});function init(param,obj){function isUseJsonp(){var isJsonp=param.isJsonp;if(isJsonp==true){return true;}else{return false;}}
    function getPageSizeOption(){var pageSizeArray=param.selfPageSizeArray;if(pageSizeArray===undefined||pageSizeArray==null||pageSizeArray.length<=0){var html='每页显示&nbsp;'+'<span class="small-pagesize-span"><span class="paging-size5 paging-size-span paging-nav paging-size-link" style="font-weight: bold;cursor: pointer;">5</span>|&nbsp;</span>'+'<span class="paging-size10 paging-size-span paging-nav paging-size-link" style="font-weight: bold;cursor: pointer;">10</span>|&nbsp;'+'<span class="paging-size20 paging-size-span paging-nav paging-size-link" style="font-weight: bold;cursor: pointer;">20</span>|&nbsp;'+'<span class="paging-size50 paging-size-span paging-nav paging-size-link" style="font-weight: bold;cursor: pointer;">50</span>'+'条&nbsp;';return html;}else{var html='每页显示&nbsp;';$(pageSizeArray).each(function(index,selfPageSize){html+='<span class="paging-size'+selfPageSize+' paging-size-span paging-nav paging-size-link" style="font-weight: bold;cursor: pointer;">'+selfPageSize+'</span>';if(index<pageSizeArray.length-1){html+='&nbsp;|&nbsp;';}});html+='&nbsp;条&nbsp;';return html;}}
    function isSelfDefinePageSize(){var pageSizeArray=param.selfPageSizeArray;if(pageSizeArray===undefined||pageSizeArray==null||pageSizeArray.length<=0)
        return false;return true;}
    function setPageSizeOptionEvent(obj){obj.find(".paging-size-span").click(function(){var newPageSize=$(this).html();pageSize=newPageSize;$.cookie(tmPagingSizeCookie,newPageSize,{expires:365,path:'/'});createView(1);});}
    function setCurrentPageSizeOption(obj,curretPageSize){var className="paging-size"+curretPageSize;if(getIsUseSmallPageSize()==false){obj.find(".small-pagesize-span").remove();}
        obj.find("."+className).removeClass("paging-size-link");obj.find("."+className).addClass("paging-size-select");}
    var tmPagingSizeCookie="tmPagingSizeCookie";if(param&&param instanceof Object){var options;var currPage;var pageCount;var pageSize;var tempPage;var resultCount;var linkNum=10;var defaults=new Object({currPage:1,pageCount:10,pageSize:5,useSmallPageSize:false,isJsonp:false,ajax:{on:false,pageCountId:'pageCount',param:{pn:1,ps:8},ajaxStart:function(){return false;}},info:{next:'下一页',prev:'上一页',next_on:true,prev_on:true,msg_on:true,link:'javascript:void(0);',msg:'<span>&nbsp;&nbsp;共&nbsp;{sumPage}&nbsp;页&nbsp;'+
        getPageSizeOption()+'到&nbsp;{currText}&nbsp;页&nbsp;<input  class="gopage-submit hand" title="跳转页面" type="button" value="确定"/></span>'}});function getCurrPage(){if(typeof options.currPage!='undefined'){return options.currPage;}else{return defaults.currPage;}}
        function getPageCount(){if(typeof options.pageCount!='undefined'){return options.pageCount;}else{return defaults.pageCount;}}
        function getResultCount(){if(options.resultCount){return options.resultCount;}else{return defaults.pageCount;}}
        function getPageSize(){if(typeof options.pageSize!='undefined'){return options.pageSize;}else{return defaults.pageSize;}}
        function getIsUseSmallPageSize(){if(typeof options.useSmallPageSize!='undefined'){return options.useSmallPageSize;}else{return defaults.useSmallPageSize;}}
        function getPrev(){if(options.info&&options.info.prev_on==false){return"";}
            if(options.info&&options.info.prev){return options.info.prev;}else{return defaults.info.prev;}}
        function getNext(){if(options.info&&options.info.next_on==false){return"";}
            if(options.info&&options.info.next){return options.info.next;}else{return defaults.info.next;}}
        function getLink(){if(options.info&&options.info.link){return options.info.link;}else{return defaults.info.link;}}
        function getAjax(){if(options.ajax&&options.ajax.on){return options.ajax;}else{return defaults.ajax;}}
        function getParam(){if(options.ajax.param){options.ajax.param.pn=currPage;options.ajax.param.ps=pageSize;return options.ajax.param;}else{defaults.ajax.param.pn=currPage;defaults.ajax.param.ps=pageSize;return defaults.ajax.param;}}
        function getPageCountId(){if(options.ajax&&options.ajax.pageCountId){return options.ajax.pageCountId;}else{return defaults.ajax.pageCountId;}}
        function getAjaxStart(){if(options.ajax&&options.ajax.ajaxStart){options.ajax.ajaxStart();}else{defaults.ajax.ajaxStart;}}
        function getMsg(){var input="<input type='text' class='jumpTo' value='"+currPage+"' >";var str;if(options.info&&options.info.msg_on==false){return false;}
            str=(options.info&&options.info.msg)?options.info.msg:defaults.info.msg;str=str.replace("{currText}",input);str=str.replace("{currPage}",currPage);str=str.replace("{sumPage}",pageCount);return str;}}
    function getText(){var msg=getMsg();if(msg){msg=$(msg);}else{return"";}
        return msg.html();}
    function isCode(val){if(val<1){TM.Alert.load('输入值不能小于1');return false;}
        var patrn=/^[0-9]{1,8}$/;if(!patrn.exec(val)){TM.Alert.load('请输入正确的数字');return false;}
        if(val>pageCount){TM.Alert.load('输入值不能大于总页数');return false;}
        return true;}
    function updateView(resultCount){currPage=parseInt(currPage);pageCount=parseInt(pageCount);var link=getLink();var lastPage;var firstPage=lastPage=1;if(currPage-tempPage>0){firstPage=currPage-tempPage;}else{firstPage=1;}
        if(firstPage+linkNum>pageCount){lastPage=pageCount+1;firstPage=lastPage-linkNum;}else{lastPage=firstPage+linkNum;}
        var content='<div class="tm-paging-container">';if(currPage==1){content+="<span class=\"page-prev page-prev-disabled\" title=\""+getPrev()+"\"></span>&nbsp;";}else{content+="<a class='page-prev page-prev-abled' href='"+link+"' title='"+(currPage-1)+"'>"+getPrev()+"</a>&nbsp;";}
        if(firstPage<=0){firstPage=1;}
        for(firstPage;firstPage<lastPage;firstPage++){if(firstPage==currPage){content+="<span class=\"paging-nav paging-select current\" title=\""+firstPage+"\">"+firstPage+"</span>&nbsp;";}else{content+="<a class='paging-nav paging-link' href='"+link+"' title='"+firstPage+"'>"+firstPage+"</a>&nbsp;";}}
        if(currPage==pageCount){content+="<span class=\"page-next page-next-disabled\" title=\""+getNext()+"\"></span>&nbsp;";}else{content+="<a class='page-next page-next-abled' href='"+link+"' title='"+(currPage+1)+"'>"+getNext()+" </a>&nbsp;";}
        content+=getText();content+='</div>';if((resultCount&&resultCount<10)){obj.html('');}else{obj.html(content);}
        setCurrentPageSizeOption(obj,pageSize);obj.find(":text").keypress(function(event){var keycode=event.which;if(keycode==13){var page=$(this).val();if(isCode(page)){createView(page);}}});obj.find(":button").click(function(){var page=obj.find(":text").val();if(isCode(page)){createView(page);}});setPageSizeOptionEvent(obj);obj.find("a").click(function(i){var page=this.title;createView(page);});}
    function createView(page){currPage=page;var ajax=getAjax();if(ajax.on){getAjaxStart();var varUrl=ajax.url;var param=getParam();var ajaxEndCallback=function(data){if(!data){return;}
        if(data.isOk){loadPageCount({dataType:ajax.dataType,callback:ajax.callback,data:data});updateView(data.count);return true;}
        else{$('#loadingImg').parents('tr').remove();if(data.message){TM.Alert.load(data.message);}}}
        if(isUseJsonp()==true){TM.Loading.init.show();$.ajax({type:"get",url:varUrl,data:param,dataType:"jsonp",success:function(data){ajaxEndCallback(data);TM.Loading.init.hidden();},error:function(){updateView();TM.Loading.init.hidden();}});}else{$.ajax({url:varUrl,type:'post',data:param,contentType:"application/x-www-form-urlencoded;utf-8",dataType:'json',error:function(jqXHR,textStatus){updateView();},success:function(data){ajaxEndCallback(data);}})}}else{updateView();}}
    function checkParam(){if(currPage<1){TM.Alert.load('配置参数错误\n错误代码:-1');return false;}
        if(pageSize<2){TM.Alert.load('配置参数错误\n错误代码:-3');return false;}
        return true;}
    function loadPageCount(options){if(options.dataType){var formData;var data=options.data;var resultPageCount=false;var isB=true;var pageCountId=getPageCountId();var callback;switch(options.dataType){case"json":formData=options.data;resultPageCount=formData.pnCount;break;case"xml":resultPageCount=$(data).find(pageCountId).text();break;default:isB=false;options.callback&&options.callback(data);resultPageCount=$("#"+pageCountId).val();break;}
        if(resultPageCount){pageCount=resultPageCount;}
        if(isB){options.callback&&options.callback(data);}}}
    options=param;currPage=getCurrPage();pageCount=getPageCount();if(getIsUseSmallPageSize()==true){tmPagingSizeCookie="SmallPageSize_"+tmPagingSizeCookie;}
    var cookiePageSize=$.cookie(tmPagingSizeCookie);if(cookiePageSize==null||cookiePageSize<=0){pageSize=getPageSize();}else{pageSize=cookiePageSize;}
    if(pageSize<=8&&getIsUseSmallPageSize()==true)
        pageSize=5;else if(pageSize<=15)
        pageSize=10;else if(pageSize<=30)
        pageSize=20;else
        pageSize=50;if(isSelfDefinePageSize()==true){tmPagingSizeCookie="SelfDefinePageSize_"+tmPagingSizeCookie;cookiePageSize=$.cookie(tmPagingSizeCookie);if(cookiePageSize==null||cookiePageSize<=0){pageSize=getPageSize();}else{pageSize=cookiePageSize;}}
    tempPage=parseInt(linkNum/2);if(checkParam()&&createView(currPage)){updateView();}}});

TM.widget.buildLeft150Nav = function () {
    var nav = $(".nav-table .nav");
    if (nav.length <= 0) {
        return;
    }
    nav.find('a.menu').click(function () {
        var me = $(this);
        var icon = me.find('i');
        var line = me.parent();
        if (line.hasClass("active")) {
            line.removeClass('active');
            line.find('.sub-lists ').hide(300);
            icon.removeClass('icon-show');
            icon.addClass('icon-fold');
        } else {
            line.addClass('active');
            line.find('.sub-lists ').show(300);
            icon.addClass('icon-show');
            icon.removeClass('icon-fold');
        }
    })
//    nav.find('a.menu').click();
    var currHref = window.location.href.toLowerCase();
    nav.find('.sub-lists a').each(function (i, elem) {
        var thisSubNav = $(elem);
        var target = thisSubNav.attr('href').toLowerCase();
        if (target.length > 3 && currHref.indexOf(target) >= 0) {
            thisSubNav.parent().parent().parent().find('a.menu').trigger('click');
            thisSubNav.find('em').addClass('rigth-small-icon');
        }
    });

}
TM.HC.init = function () {
    me.page = $('.main .pagenav');
    me.container = $('.main .container');
    me.headTitle = $('.main .head-title');
    me.level2s = $('.main-lists .level2');
    me.tmpl = $('#articleTmpl');
    me.searchBtn = $('#top-header .searchBtn');
    me.inputEditor = $('#top-header #searchInput');
    me.inputTip = $('#top-header #inputTip');
    me.bindListeners();
    var articleId = null;
    var page_url = window.location.href;
    var start = page_url.indexOf('/helpcenter/article/');
    if (start >= 0) {
        articleId = page_url.substring(start + '/helpcenter/article/'.length, page_url.indexOf('.htm'));
    } else {
    }
    if (articleId && articleId > 0) {
        me.loadOneArticle(articleId);
    } else {
        $('.leftnav .menu:eq(0)').trigger('click');
        me.level2s.eq(0).trigger('click');
    }

    var href = window.location.href;
    var params = $.url(href);
    var s = params.param('s');
    if(s && s.length > 0){
        me.inputEditor.focus();
        me.inputEditor.val(s);
        me.doSearch();
    }

}

$(document).ready(function(){
    TM.widget.buildLeft150Nav();
    TM.HC.init();
    $("#helpcenternav").addClass('current');
})
