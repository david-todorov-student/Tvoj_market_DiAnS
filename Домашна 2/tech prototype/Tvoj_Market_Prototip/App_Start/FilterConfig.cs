using System.Web;
using System.Web.Mvc;

namespace Tvoj_Market_Prototip
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
