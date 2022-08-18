package gui.util;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static Stage currentStage(ActionEvent event){
        return (Stage) ((Node) event.getSource()).getScene().getWindow();
    }

    public static Integer tryParseToInt(String str){
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    public static Double tryParseToDouble(String str){
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e){
            return null;
        }
    }

    public static <T> void formatTableColumnDate(TableColumn<T, Date> tableColumn, String format){
        tableColumn.setCellFactory(column -> {
            TableCell<T, Date> cell = new TableCell<T, Date>(){
                private final SimpleDateFormat sdf = new SimpleDateFormat(format);

                @Override
                protected void updateItem(Date item, boolean empty){
                    super.updateItem(item, empty);
                    if (empty){
                        setText(null);
                    } else {
                        setText(sdf.format(item));
                    }
                }
            };
            return cell;
        });
    }

    public static <T> void formtTableColumnDouble(TableColumn<T, Double> tableColumn, int decimalPlaces){
        tableColumn.setCellFactory(column -> {
            TableCell<T, Double> cell = new TableCell<T, Double>(){
                @Override
                protected void updateItem(Double item, boolean empty){
                    super.updateItem(item, empty);

                    if (empty){
                        setText(null);
                    } else {
                        Locale.setDefault(Locale.US);
                        setText(String.format("%." + decimalPlaces + "f", item));
                    }
                }
            };
            return cell;
        });
    }

    public static void formatDataPicker(DatePicker datePicker, String format){
        datePicker.setConverter(new StringConverter<LocalDate>() {
            final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);
            {
                datePicker.setPromptText(format.toLowerCase());
            }

            @Override
            public String toString(LocalDate localDate) {
                if (localDate != null){
                    return dateTimeFormatter.format(localDate);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String s) {
                if (s != null && !s.isEmpty()){
                    return LocalDate.parse(s, dateTimeFormatter);
                } else {
                    return null;
                }
            }
        });
    }
}
