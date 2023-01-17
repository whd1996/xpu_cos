function toCommodity(currentPage,pageSize) {
    $.ajax({
        url: "/commodity/selectALLCommodityUsePage?currentPage="+currentPage+"&pageSize="+pageSize,
        type: 'get',
        success: function () {
            $("#commodityHtml").attr("href","/index/commodity");
        }
    });
}