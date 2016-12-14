$(document).on("click", ".open-AddActivity", function () {
    var trainingId = $(this).data('id').trainingId;
    var exerciseId = $(this).data('id').exerciseId;
    $(".modal-body #trainingId").val( trainingId );
    $(".modal-body #exerciseId").val( exerciseId );
});

$(document).on("click", ".open-EditGroup", function () {
    var groupId = $(this).data('id');
    var groupName = $(this).data('name');
    $(".modal-body #groupId").val(groupId);
    $(".modal-body #groupName").val(groupName);
});

$(document).on("click", ".open-EditExercise", function () {
    var exerciseId = $(this).data('id');
    var exerciseName = $(this).data('name');
    $(".modal-body #exerciseId").val(exerciseId);
    $(".modal-body #exerciseName").val(exerciseName);
});