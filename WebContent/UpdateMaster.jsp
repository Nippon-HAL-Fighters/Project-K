<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.CompanieBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.OrganaizationBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.EmployeeBean"%>
<%@page import="jp.ac.hal.tokyo.nippon_hal_fighters.beans.PostBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//ArrayList<PostBean> postrecode = (ArrayList<PostBean>)request.getAttribute("postlist");
	//ArrayList<OrganaizationBean> orgrecode = (ArrayList<OrganaizationBean>)request.getAttribute("orglist");
	//ArrayList<CompanieBean> comprecode = (ArrayList<CompanieBean>)request.getAttribute("complist");
	String updatetype = (String)request.getAttribute("updatetype");
%>
<!DOCTYPE html>
<html>
  <head>
    <title>マスタ情報更新</title>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="./css/styles.css" type="text/css" />
    <link rel="stylesheet" href="./css/font-awesome/font-awesome.css" type="text/css" />
    <link rel="stylesheet" href="./css/template.css" type="text/css" />
    <link rel="stylesheet" href="./css/employeeentry.css" type="text/css" />
    <script src="./js/jquery-2.1.4.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <script src="./js/script.js"></script>
    <script src="./js/updmaster.js"></script>
   	</head>
<body>
    <!-- 共通部分 -->
    <nav>
        <header>
            <img src="./img/hal_fighters.png" />
            <a href="./index.html">
                <h1>要員管理システム</h1>
            </a>
        </header>
        <form class="input-group">
            <div>
                <select class="form-control">
                    <option>在席中</option>
                    <option>離席中</option>
                    <option>会議中</option>
                    <option>出張中</option>
                    <option>長期病気療養中</option>
                    <option>その他</option>
                </select>
            </div>
            <div>
                <input class="form-control" type="text" placeholder="書き置き" disabled="true" />
            </div>
            <div>
                <input class="btn" type="submit" value="更新" disabled="true" />
            </div>
        </form>
        <ul>
            <a href="">
                <li><i class="fa fa-home"></i>TOPページ</li>
            </a>
            <a href="">
                <li><i class="fa fa-list"></i>社員情報一覧</li>
            </a>
            <a href="">
                <li><i class="fa fa-user-plus"></i>社員情報登録</li>
            </a>
            <a href="">
                <li><i class="fa fa-cog"></i>マスタ情報更新</li>
            </a>
            <a href="">
                <li><i class="fa fa-pencil"></i>組織図作成</li>
            </a>
            <a href="">
                <li><i class="fa fa-sitemap"></i>組織図閲覧</li>
            </a>
            <a href="">
                <li><i class="fa fa-pencil"></i>座席表作成</li>
            </a>
            <a href="">
                <li><i class="fa fa-th"></i>座席表閲覧</li>
            </a>
            <a href="">
                <li class="nav-last"><i class="fa fa-sign-out"></i>ログアウト</li>
            </a>
        </ul>
    </nav>
    <!-- 共通部分ここまで -->
    <main>
    	<div id="main-form">
	        <h2>マスタ情報更新</h2>
	       <form action="UpdateMaster" method="post">
	        	<div class="form">

				<%
					if(updatetype.equals("org")){	//組織だった場合
						OrganaizationBean orgBean = (OrganaizationBean)request.getAttribute("orgBean");
						out.print("<h2>組織</h2><label id=\"errorgid\" style=\"display:none;color:red;\"></label>"
						+"組織ID：<input type=\"text\" name=\"orgid\" class=\"form-control\" value="+orgBean.getOrganaizationId()+" />"
						+"<label id=\"errorgname\" style=\"display:none;color:red;\"></label>"
						+"組織名：<input type=\"text\" name=\"orgname\" value="+orgBean.getOrganaizationName()+">"
						+"<input type=\"hidden\" name=\"updatetype\" value=\"org\" />"
						+"<input type=\"hidden\" name=\"ordid\" value="+orgBean.getOrganaizationId()+" />");
					}else if(updatetype.equals("post")){	//役職だった場合
						PostBean postBean = (PostBean)request.getAttribute("postBean");
						out.print("<h2>役職</h2><label id=\"errpost\" style=\"display:none;color:red;\"></label>"
						+"役職名:<input type=\"text\" name=\"postname\" value="+postBean.getPostName()+">"
						+"<input type=\"hidden\" name=\"postid\" value="+postBean.getPostId()+" />"
						+"<input type=\"hidden\" name=\"updatetype\" value=\"post\" />");
					}else if(updatetype.equals("comp")){	//会社だった場合
						CompanieBean compBean = (CompanieBean)request.getAttribute("compBean");
						out.print("<h2>会社</h2><label id=\"errcomp\" style=\"display:none;color:red;\"></label>"
						+"会社:<input type=\"text\" name=\"compname\" value="+compBean.getCompanyName()+">"
						+"<input type=\"hidden\" name=\"compid\" value="+compBean.getCompanyId()+" />"
						+"<input type=\"hidden\" name=\"updatetype\" value=\"comp\" />");
					}
				%>	
				
				</div>
	        	<input type="submit" value="更新" class="btn btn-default" />
	        </form>
        </div>
    </main>
</body>
</html>
