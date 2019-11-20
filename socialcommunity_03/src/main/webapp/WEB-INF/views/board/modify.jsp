<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<%@include file="../includes/header.jsp"%>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Register</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>

			<!-- /.panel-heading -->
			<div class="panel-body">
				
				
				
			<form action="/board/modify" role="form" method="post">
				
					<div class="form-group">
					  <label>Bno</label> 
					  <input class="form-control" name='bno' 
					     value='<c:out value="${board.bno }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
					  <label>Title</label> 
					  <input class="form-control" name='title' 
					    value='<c:out value="${board.title }"/>' >
					</div>
					
					<div class="form-group">
					  <label>Text area</label>
					  <textarea class="form-control" rows="3" name='content' ><c:out value="${board.content}"/></textarea>
					</div>
					
					<div class="form-group">
					  <label>Writer</label> 
					  <input class="form-control" name='writer'
					    value='<c:out value="${board.writer}"/>' readonly="readonly">            
					</div>
					
					<div class="form-group">
					  <label>RegDate</label> 
					  <input class="form-control" name='regdate'
					    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regdate}" />'  readonly="readonly">            
					</div>
					
					<div class="form-group">
					  <label>Update Date</label> 
					  <input class="form-control" name='updatedate'
					    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.updatedate}" />'  readonly="readonly">            
					</div>
					
					
					
					<button
					 data-oper="modify"
					 type="submit"
					 class="btn btn-default">
					 Modify
					 </button>
					 
					<button
					 data-oper="remove"
					 type="submit"
					 class="btn btn-danger">
					 Remove
					 
					 </button>
					 	<button
					 data-oper="list"
					 type="submit"
					 class="btn btn-info">
					 List
					 
					 </button>
					 </form>
				
		</div>
		<!--  end panel-body -->
	</div>
	<!-- end panel -->
</div>
</div>
<!-- /.row -->
<script type="text/javascript">
$(document).ready(function() {
	/* var operForm = $("#operForm"); 
	  
	  $("button[data-oper='modify']").on("click", function(e){
	    
	    operForm.attr("action","/board/modify").submit();
	    
	  });
	  
	    
	  $("button[data-oper='list']").on("click", function(e){
	    
	    operForm.find("#bno").remove();
	    operForm.attr("action","/board/list")
	    operForm.submit();
	    
	  });   */
 

	  var formObj = $("form");

	  $('button').on("click", function(e){
	    
	    e.preventDefault(); 
	    
	    var operation = $(this).data("oper");
	    
	    console.log(operation);
	    
	    if(operation === 'remove'){
	      formObj.attr("action", "/board/remove");
	      
	    }else if(operation === 'list'){
	    	self.location="/board/list";
	    	return;
	      //move to list
	      //formObj.attr("action", "/board/list").attr("method","get");
	      
	/*       var pageNumTag = $("input[name='pageNum']").clone();
	      var amountTag = $("input[name='amount']").clone();
	      var keywordTag = $("input[name='keyword']").clone();
	      var typeTag = $("input[name='type']").clone();       */
	      
	      //formObj.empty();
	      
	/*       formObj.append(pageNumTag);
	      formObj.append(amountTag);
	      formObj.append(keywordTag);
	      formObj.append(typeTag);	        */
	    }
	    formObj.submit();
	  });

});
</script>
<%@include file="../includes/footer.jsp"%>
