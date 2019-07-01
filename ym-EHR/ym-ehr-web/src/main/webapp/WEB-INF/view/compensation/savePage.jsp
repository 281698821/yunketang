
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="hp-open-list">
    <div class="demoTable">
        搜索名字：
        <div class="layui-inline">
            <input class="layui-input" name="name" id="demoReload2" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
    </div>

    <table class="layui-hide" id="kd-table" lay-filter="emp"></table>
    <button class="layui-btn layui-btn-small bcql-icon"
            lay-submit lay-filter="save" style="display: none;"></button>
    <%--<script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    </script>--%>

</div>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    // 初始化数据
    var data={
        id:"${compensation.id}",
        emp:"${compensation.emp}"
    }
</script>
<script type="text/javascript" src="/js/compensation/savePage.js"></script>


