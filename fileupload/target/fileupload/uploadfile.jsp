<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="text-center">
    <h2>图片预览</h2>
    <img id="showImg" src="resources/images/img3-lg.jpg" alt="img3-lg.jpg">
    <hr style="width: 50%">
    <div id="smallImg">
        <a href="resources/images/img2-lg.jpg" title="img2-lg.jpg">
            <img src="resources/images/img2-thumb.jpg" alt="img2-thumb.jpg"/>
        </a>
        <a href="resources/images/img3-lg.jpg" title="img3-lg.jpg">
            <img src="resources/images/img3-thumb.jpg" alt="img3-thumb.jpg"/>
        </a>
        <a href="resources/images/img4-lg.jpg" title="img4-lg.jpg">
            <img src="resources/images/img4-thumb.jpg" alt="img4-thumb.jpg"/>
        </a>
        <a href="resources/images/img5-lg.jpg" title="img5-lg.jpg">
            <img src="resources/images/img5-thumb.jpg" alt="img5-thumb.jpg"/>
        </a>

        <a href="resources/images/img6-lg.jpg" title="img6-lg.jpg">
            <img src="resources/images/img6-thumb.jpg" alt="img6-thumb.jpg"/>
        </a>
    </div>
    <hr style="width: 50%">
    <img id="previewImg" src="resources/images/preview.jpg" alt="preview.jpg" width="80" height="80">
    <div id="large"></div>
    <form class="form-inline" id="myForm" action="${pageContext.request.contextPath}/uploadServlet" enctype="multipart/form-data" method="post">
        <div class="form-group">
            <label for="myFile">File:</label>
            <input id="myFile" type="file" class="form-control" name="file">
        </div>
        <div class="form-group">
            <label>File:</label>
            <input type="submit" class="form-control" value="上传">
        </div>
    </form>
    下载：<a href="${pageContext.request.contextPath}/downloadServlet?filename=文件下载.txt">文件下载</a>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function(){
        $('#smallImg a').click(function(){
            var imgHref = $(this).attr('href');
            var imgTitle = $(this).attr('title');
            $('#showImg').attr({
                src: imgHref,
                alt: imgTitle
            });
            return false;
        });
        $('#myFile').change(function() {
            $('#previewImg').attr('src',getObjectURL(this.files[0]));
        });

        $('#large').hide();
        $('#previewImg').mousemove(function(e){
            console.log(e.pageX,e.pageY);
            $('#large').css({
                position:'absolute',
                top:e.pageY,//todo 未实现图片随鼠标移动而移动
                left:e.pageX
            }).html('<img src="'+ this.src+'"/>').show();
        }).mouseout(function(){
            $('#large').hide();
        });
    });
    //用于获取图片上传路径问题
    function getObjectURL(file) {
        var url = null;
        if (window.createObjcectURL != undefined) {
            url = window.createOjcectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
</script>
</body>
</html>
