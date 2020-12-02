using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Tvoj_market_prototype.Models
{
    public class Market
    {
        [Key]
        public int Id { get; set; }
        [Display(Name = "Longitude")]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:0.0000000}")]
        public string Longitude  { get; set; }
        [Display(Name = "Latitude")]
        [DisplayFormat(ApplyFormatInEditMode = true, DataFormatString = "{0:0.0000000}")]
        public string Latitude { get; set; }
        public string Name { get; set; }
        public string Address { get; set; }
        [Display(Name = "Opening Hour")]
        public int OpeningHour { get; set; }
        [Display(Name = "Closing Hour")]
        public int ClosingHour { get; set; }
        public string Website { get; set; }
        public string Phone { get; set; }
    }
}