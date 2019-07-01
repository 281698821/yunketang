<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
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
<!-- 数据表格 -->
<table class="layui-table" id="dataTable" lay-filter="tableTool" ></table>
<!-- 操作按钮 -->
<script type="text/html" id="barTool">
    <a class="layui-btn layui-btn-xs updateBtn" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>

<script src="/lib/layui/layui.js"></script>


<script src="/js/rule/list.js"></script>
</body>
</html>
