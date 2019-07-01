<%--
  Created by IntelliJ IDEA.
  User: lx
  Date: 2019/1/16
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="layui-form-item hp-form-item">
                    <div class="layui-inline hp-form-inline">
                        <label class="layui-form-label hp-form-label">奖罚表：</label>
                        <div class="layui-input-inline" style="width: 200px;">
                            <select name="money" lay-verify="">
                                <option value="">请选择一个说明</option>
                                <option value="500">绩效奖励</option>
                                <option value="300">全勤奖励</option>
                                <option value="350">工作时间抽烟喝酒打游戏</option>
                                <option value="50">迟到罚款</option>
                                <option value="100">旷工罚款</option>
                            </select>
                        </div>
                    </div>

                    <div class="layui-inline hp-form-inline">
                        <div class="layui-input-inline" style="width: 150px;">
                            <button class="layui-btn" lay-submit="" lay-filter="searchForm">查询</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>

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


<script src="/js/rewardPunish/list.js"></script>
</body>
</html>
