package fileReader;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IFileProcessor<T>
{	
	public List<T> parseCSVToBeanList(String fileName, Map<String,String> headerColumnMap, Class<T> t) throws IOException;
}