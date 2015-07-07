var reportPageSize = 10;
var pageNo = 0;
function populateReportData() {
	resultCount = 0;
	params = {};
	current_page = 0;
	populateAdditionalParams();
	params.pageSize = reportPageSize;
	params.searchval = $("#searchval").val();
	return true;
}
function getResultCount() {
	current_page = pageNo;
	if($("#spinnerImg").length){
		showSpinner();
		$("#searchResults").html("");
		$("#pagination").html("");
	}
	$.ajax({
		url : counturl,
		data : params,
		type : "post",
		success : function(data) {
			resultCount = parseInt(data);
			paginateResults();
		}
	});
	return false;
}
function paginateResults() {
	$("#pagination").pagination(resultCount, {
		items_per_page : params.pageSize,
		num_display_entries : 4,
		num_edge_entries : 1,
		current_page : current_page,
		callback : populateResults
	});
	if(resultCount>0){
		$("#download").show();
	}
}
function populateResults(page_index, jq) {
	current_page = page_index;
	pageNo = page_index;
	params.pageNum = page_index + 1;
	$.ajax({
		url : resulturl,
		data : params,
		type : "post",
		success : function(resultdata) {
			if($("#spinnerImg").length){
				hideSpinner();
			}
			$("#searchResults").html(resultdata);
			if (resultCount == 0) {
				$(".searchResults").hide();
				$(".pagination").hide();
				$(".pagination-location").hide();
				$("#pagination").html("");
			} else {
				$(".pagination").show();
				$(".pagination-location").show();
			}
		}
	});

	 return false;
}
function sortResults(sortColumn, sortOrder) {
	params.sortColumn = sortColumn;
	params.sortOrder = sortOrder;
	paginateResults();
}

function sortResultswoPagination(sortColumn, sortOrder) {
	localParams.sortColumn = sortColumn;
	localParams.sortOrder = sortOrder;
	if($("#rangeA").val()!="Choose a Date"){
		localParams.dateRange = $("#rangeA").val();
	}
	localParams.searchEntity = $("#searchEntity").val();
	localParams.clientCampaignId = $("#clientCampaignSearch").val();
	sendPostRequest(resulturl,"searchResults",localParams);
}
function validateData() {
	return true;
}