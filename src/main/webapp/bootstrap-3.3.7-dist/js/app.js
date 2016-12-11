$(document).on("click", ".open-AddActivity", function () {
    var trainingId = $(this).data('id').trainingId;
    var exerciseId = $(this).data('id').exerciseId;
    $(".modal-body #trainingId").val( trainingId );
    $(".modal-body #exerciseId").val( exerciseId );
});