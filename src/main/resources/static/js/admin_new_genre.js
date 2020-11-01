$(function(){
    var pickr = new Pickr({

        el: '#color-picker',
        showAlways: false,
        position: 'left',
        defaultRepresentation: 'RGBA',

        components: {
 
            preview: true, // Left side color comparison
            opacity: true, // Opacity slider
            hue: true,     // Hue slider
     
            // Bottom output bar, theoretically you could use 'true' as propery.
            // But this would also hide the save-button.
            interaction: {
                // hex: true,
                rgba: true,
                // hsla: true,
                // hsva: true,
                // cmyk: true,
                input: true,
                clear: true,
                save: true
            }
        },



        strings: {
           save: 'Save',  // Default for save button
           clear: 'Clear' // Default for clear button
        },
     
        // User has changed the color
        onChange(hsva, instance) {
            hsva;     // HSVa color object, if cleared null
            instance; // Current Pickr instance
        },
     
        // User has clicked the save button
        onSave(hsva, instance) {
            // same as onChange
            console.log("save");

            console.log($(".pcr-result").val());
        }

      });

    pickr.on('save', (color, instance) => {
        // console.log('save', color.toRGBA(), instance);

        // console.log($(".pcr-result").val());

        $(".image-color-input").val($(".pcr-result").val());
    }).on('clear', instance => {
        // console.log('clear', instance);
        $(".image-color-input").val("");
    })

})