function magClick(id){
	nid=id+1;
	$("#content_Goods1").hide();
	$("#content_Goods").removeClass("activea");
	$("#content_Cate1").hide();
	$("#content_Cate").removeClass("activea");
	$("#content_Order1").hide();
	$("#content_Order").removeClass("activea");
	$("#"+nid).show();	
	$("#"+id).addClass("activea");	
}
