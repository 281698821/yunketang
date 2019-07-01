<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <meta charset="utf-8">
    <title>数据列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="/lib/layui/css/layui.css">
    <link rel="stylesheet" type="text/css"
          href="/css/hp-common.css"/>
</head>
<body>
<div class="hp-div-form">
    <blockquote class="layui-elem-quote">
        <form class="layui-form" id="search-form">
                <div class="layui-inline hp-form-inline">
                    <label class="layui-form-label hp-form-label">离职表：</label>
                   <%-- <div class="layui-inline">
                        <label class="layui-form-label">开始时间</label>
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="start_date" name="start_date" placeholder="yyyy-MM-dd"value="">
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">结束时间</label>
                        <div class="layui-input-inline">
                            <input type="text" class="layui-input" id="end_date" name="end_date" placeholder="yyyy-MM-dd" value="">
                        </div>
                    </div>--%>
                <%--<div class="layui-inline hp-form-inline">
                    <div class="layui-input-inline" style="width: 150px;">
                        <button class="layui-btn" lay-submit="" lay-filter="searchForm">查询</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>--%>

            </div>
        </form>
    </blockquote>
</div>

<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-group demoTable">
        <button id="addBtn" class="layui-btn layui-btn-normal">
            <i class="layui-icon"></i>添加
        </button>
        <button id="deletesBtn" class="layui-btn layui-btn-danger">
            <i class="layui-icon"></i>删除
        </button>
        <button id="refrsh" class="layui-btn hp-btn-green">
            <i class="layui-icon">&#xe669;</i>刷新
        </button>
        <button id="export" class="layui-btn hp-btn-green">
            <i class="layui-icon">&#xe601</i>导出
        </button>
    </div>
</script>

<!-- 数据表格 -->
<table class="layui-table" id="dataTable" lay-filter="tableTool" ></table>

<!-- 操作按钮 -->
<script type="text/html" id="barTool">
    <a class="layui-btn layui-btn-xs updateBtn" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>


</body>

<script src="/lib/layui/layui.js"></script>


<script src="/js/departure/list.js"></script>
</body>
</html>
