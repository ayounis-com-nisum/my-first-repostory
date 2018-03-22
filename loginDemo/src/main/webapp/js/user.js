function readURL(input) {
	$('#userName').val();
	alert("------");
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#userPhoto').attr('src', e.target.result);
        };

        reader.readAsDataURL(input.files[0]);
    }
}

/*$(document).ready(function table() {
	
    $('#userTable').jtable({
    	paging : true,
		pageSize : 25,
		sorting : true,
		multiSorting: true,
        actions : {
//          listAction : 'get',
            listAction : function (postData, jtParams) {
            	
                return $.Deferred(function ($dfd) {
                    $.ajax({
                        url: 'getAllUsers',
                        type: 'GET',
                        dataType: 'json',
                        data: postData,
                        success: function (data) {
                            $dfd.resolve(data);
                        },
                        error: function () {
                            $dfd.reject();
                        }
                    });
                });
            },
			
        },
        fields : {
            userId : {
                title : 'User Id',
                key : true,
                width : '15%'
            },
            userName : {
                title : 'User Name',
                width : '30%',
                type : 'hidden-edit'
            },
           
            
        }
    });
    $('#search').click(function(e) {
		
		$('#userTable').jtable('load', {
			//userName : $('#userName').val(),
			
		});
	});
  //  $('#userTable').jtable('load');
});*/
$(document)
.ready(	function() {
	
			$('#userTable')
					.jtable({
							recordsLoaded : function(event, data) {
									$('.jtable-data-row').click(
													function() {
														bookCrud($(this).find("#bookId").val(),'Update',
																'rest/bookRESTService/getBook');
													});
								},
								paging : true,
								pageSize : 25,
								sorting : true,
								defaultSorting : 'userName ASC',
								actions : {
//						          listAction : 'get',
						            listAction : 'getAllUsers', 
						           
						        },
								/*action :{
								listAction : function (postData, jtParams) {
					            	
					                return $.Deferred(function ($dfd) {
					                    $.ajax({
					                        url: 'getAllUsers',
					                        type: 'GET',
					                        dataType: 'json',
					                        data: postData,
					                        success: function (data) {
					                            $dfd.resolve(data);
					                        },
					                        error: function () {
					                            $dfd.reject();
					                        }
					                    });
					                });
					            },
								},*/
								fields : {
									
									userName : {
										title : 'User Name',
										width : '15%'
									},
									
									
									userId : {
										title : 'User id',
										width : '15%'
									},
									

								}
							});
					

			// $('#userTable').jtable('load');
			 
			$('#search').click(function(e) {
				e.preventDefault();
				//validateIntegerValues();
				$('#userTable').jtable('load', {
					userName : $('#userName').val(),
					
				});
			});

			//Load all records when page is first shown
			//$('#search').click();
			//validateIntegerValues();
		});