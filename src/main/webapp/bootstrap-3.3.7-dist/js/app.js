$(document).on("click", ".open-AddActivity", function () {
    var trainingId = $(this).data('id').trainingId;
    var exerciseId = $(this).data('id').exerciseId;
    $(".modal-body #trainingId").val( trainingId );
    $(".modal-body #exerciseId").val( exerciseId );
});

$(document).on("click", ".open-EditGroup", function () {
    var groupName = $(this).data('name');
    var groupId = $(this).data('id');
    $(".modal-body #groupName").val(groupName);
    $(".modal-body #groupId").val(groupId);
});