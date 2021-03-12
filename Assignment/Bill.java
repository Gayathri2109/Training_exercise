import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import com.graphbuilder.struc.Stack;

class Bill {
		private String itemname;
		private int sno;
		private int unit;
		private int price;
		private int qty;
		private int tot;
		
		public String getItemname() {
			return itemname;
		}
		public void setItemname(String itemname) {
			this.itemname = itemname;
		}
		public int getSno() {
			return sno;
		}
		public void setSno(int sno) {
			this.sno = sno;
		}
		public int getUnit() {
			return unit;
		}
		public void setUnit(int unit) {
			this.unit = unit;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public int getTot() {
			return tot;
		}
		public void setTot(int tot) {
			this.tot = tot;
		}
		@Override
		public String toString() {
			return "Bill [itemname=" + itemname + ", sno=" + sno + ", unit=" + unit + ", price=" + price + ", qty=" + qty
					+ ", tot=" + tot + "]";
		}
	}

class MyHandler extends DefaultHandler{
	
	private String str;
	
	private String name;
	private String date;
	private String billno;
	
	ArrayList<String> array = new ArrayList<String>();
	
	public void setName(String name) {
		this.name = name;
		array.add(name);
	}

	public void setBillno(String billno) {
		this.billno = billno;
		array.add(billno);
	}

	public void setdate(String date) {
		this.date = date;
		array.add(date);
	}

	//ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
	private ArrayList userList = new ArrayList();
	 
	
    private Stack elementStack = new Stack();
 
    private Stack objectStack = new Stack();
	
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		this.elementStack.push(qName);
        if ("item".equals(qName))
        {
            Bill user = new Bill();
            this.objectStack.push(user);
        }
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		this.elementStack.pop();
        if ("item".equals(qName))
        {
            Bill object = (Bill)this.objectStack.pop();
            this.userList.add(object);
        }
        

        switch(qName)
        {
        case "customername":{
        	this.setName(str);
        	break;
        }
        case "date":{
        	this.setdate(str);
        	break;
        }
        case "billno":{
        	this.setBillno(str);
        	break;
        }
        }
        
	}
	
	@Override
	public String toString() {
		return "MyHandler [name=" + name + ", date=" + date + ", billno=" + billno + "]";
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		str = new String(ch,start,length);
		if (str.length() == 0)
        {
            return; // to ignore white space
        }
        if ("sno".equals(currentElement()))
        {
            Bill user = (Bill) this.objectStack.peek();
            user.setSno(Integer.parseInt(str));
        }
        else if ("itemname".equals(currentElement()))
        {
            Bill user = (Bill) this.objectStack.peek();
            user.setItemname(str);
        }
        else if ("unit".equals(currentElement()))
        {
            Bill user = (Bill) this.objectStack.peek();
            user.setUnit(Integer.parseInt(str));
        }
        else if ("price".equals(currentElement()))
        {
            Bill user = (Bill) this.objectStack.peek();
            user.setPrice(Integer.parseInt(str));
        }
        else if ("quantity".equals(currentElement()))
        {
            Bill user = (Bill) this.objectStack.peek();
            user.setQty(Integer.parseInt(str));
        }
        else if ("totalamt".equals(currentElement()))
        {
            Bill user = (Bill) this.objectStack.peek();
            user.setTot(Integer.parseInt(str));
        } 
	}
	
	private String currentElement()
    {
        return (String)this.elementStack.peek();
    }
 
    public ArrayList getUsers()
    {
        return userList;
    }
	
    public ArrayList getDetails()
    {
    	return array;
    }
}

class UsersXmlParser
{
    public ArrayList parseXml(InputStream in)
    {
        ArrayList<Bill> users = new ArrayList<Bill>();
        try
        {
            MyHandler handler = new MyHandler();
            XMLReader parser = XMLReaderFactory.createXMLReader();
            parser.setContentHandler(handler);
            InputSource source = new InputSource(in);
 
            //parse the document
            parser.parse(source);
 
            //populate the parsed users list in above created empty list; You can return from here also.
            users = handler.getUsers();
 
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
 
        }
        return users;
    }
    
}